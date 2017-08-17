package com.sailing.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/***
 * 
 * @author Administrator
 * 
 */
public class MyFileUtil {
	public static final long ONE_KB = 1024;
	public static final long ONE_MB = ONE_KB * ONE_KB;
	public static final long ONE_GB = ONE_KB * ONE_MB;
	public static final DateFormat pathDf = new SimpleDateFormat("yyyyMM");
	public static final DateFormat nameDf = new SimpleDateFormat("ddHHmmss");
	static int countFiles = 0;// 声明统计文件个数的变量
	static int countFolders = 0;// 声明统计文件夹的变量

	/* [文件删除] */

	// 验证字符串是否为正确路径名的正则表达式
	private static String matches = "[A-Za-z]:\\\\[^:?\"><*]*";
	// 通过spath.matches(matches)方法的返回值判断是否正确
	static boolean flag = false;
	static File file;

	public static String getType(String file){
		if(new File(file).isDirectory()){
			return "floder";
		}else{
			return "file";
		}
	}
	
	public static String getTime(String file){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(new File(file).lastModified()));
	}
	
	// 根据路径删除指定目录或文件，无论存在与否。
	public static boolean DeleteFolder(String deletePath) {
		flag = false;
		if (deletePath.matches(matches)) {
			file = new File(deletePath);
			if (!file.exists()) {
				return flag;
			} else {
				if (file.isFile()) {
					return deleteFile(deletePath);
				} else {
					return deleteDirectory(deletePath);
				}
			}
		} else {
			System.out.println("要传入正确路径!!!");
			return false;
		}
	}

	// 删除文件
	public static boolean deleteFile(String filePath) {
		flag = false;
		file = new File(filePath);
		if (file.isDirectory()) {
			return deleteDirectory(filePath);
		}
		if (file.isFile() && file.exists()) {
			file.delete();
			return flag = true;
		}
		return flag;
	}

	// 删除文件
	public static boolean deleteFile(String[] filePaths) {
		for (String string : filePaths) {
			File file = new File(string);
			if (file.isFile() && file.exists()) {
				file.delete();
			}
		}
		return true;
	}

	// 删除文件
//	public static boolean deleteFile(String[] filePaths, String path) {
//		try {
//			for (String string : filePaths) {
//				File file = new File(path + "/"
//						+ JxtvStringUtil.transferEncoding(string, "gbk"));
//				if (file.isFile() && file.exists()) {
//					file.delete();
//				} else {
//					if (file.isDirectory()) {
//						deleteDirectory(file);
//					}
//				}
//			}
//			return true;
//
//		} catch (Exception e) {
//			return false;
//		}
//	}

	// 删除目录及目录下的文件
	public static boolean deleteDirectory(String filePath) {
		// 如果spath不以文件分隔结尾，自动添加文件分隔符
		if (!filePath.endsWith(File.separator)) {
			filePath = filePath + File.separator;
		}
		return deleteDirectory(new File(filePath));
	}

	// 删除目录及目录下的文件
	public static boolean deleteDirectory(File dirFile) {
		// 如果文件或者文件夹不存在，则退出
		if (!dirFile.exists() && !dirFile.isDirectory()) {
			return false;
		}
		flag = true;
		File[] files = dirFile.listFiles();
		// 遍历删除文件夹中的文件
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			} else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}
		if (!flag) {
			return false;
		}
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}

	public static void deleteDirectorys(File directory) throws IOException {
		if (!directory.exists()) {
			return;
		}

		cleanDirectory(directory);
		if (!directory.delete()) {
			String message = "Unable to delete directory " + directory + ".";
			throw new IOException(message);
		}
	}

	public static void forceDelete(File file) throws IOException {
		if (file.isDirectory()) {
			deleteDirectory(file);
		} else {
			boolean filePresent = file.exists();
			if (!file.delete()) {
				if (!filePresent) {
					throw new FileNotFoundException("File does not exist: "
							+ file);
				}
				String message = "Unable to delete file: " + file;
				throw new IOException(message);
			}
		}
	}

	public static boolean deleteQuietly(File file) {
		if (file == null) {
			return false;
		}
		try {
			if (file.isDirectory()) {
				cleanDirectory(file);
			}
		} catch (Exception e) {
		}

		try {
			return file.delete();
		} catch (Exception e) {
			return false;
		}
	}

	public static void cleanDirectory(File directory) throws IOException {
		if (!directory.exists()) {
			String message = directory + " does not exist";
			throw new IllegalArgumentException(message);
		}

		if (!directory.isDirectory()) {
			String message = directory + " is not a directory";
			throw new IllegalArgumentException(message);
		}

		File[] files = directory.listFiles();
		if (files == null) { // null if security restricted
			throw new IOException("Failed to list contents of " + directory);
		}

		IOException exception = null;
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			try {
				forceDelete(file);
			} catch (IOException ioe) {
				exception = ioe;
			}
		}

		if (null != exception) {
			throw exception;
		}
	}

	private static void deleteDirectoryOnExit(File directory)
			throws IOException {
		if (!directory.exists()) {
			return;
		}

		cleanDirectoryOnExit(directory);
		directory.deleteOnExit();
	}

	public static void cleanDirectoryOnExit(File directory) throws IOException {
		if (!directory.exists()) {
			String message = directory + " does not exist";
			throw new IllegalArgumentException(message);
		}

		if (!directory.isDirectory()) {
			String message = directory + " is not a directory";
			throw new IllegalArgumentException(message);
		}

		File[] files = directory.listFiles();
		if (files == null) { // null if security restricted
			throw new IOException("Failed to list contents of " + directory);
		}

		IOException exception = null;
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			try {
				forceDeleteOnExit(file);
			} catch (IOException ioe) {
				exception = ioe;
			}
		}

		if (null != exception) {
			throw exception;
		}
	}

	public static void forceDeleteOnExit(File file) throws IOException {
		if (file.isDirectory()) {
			deleteDirectoryOnExit(file);
		} else {
			file.deleteOnExit();
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public static void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myDelFile = new File(filePath);
			myDelFile.delete();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * 删除文件夹
	 * 
	 * @param filePathAndName
	 *            String 文件夹路径及名称 如c:/fqf
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * 删除文件夹里面的所有文件
	 * 
	 * @param path
	 *            String 文件夹路径 如 c:/fqf
	 */
	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
			}
		}
	}

	/**
	 * 删除单个文件(通过命令的方式删除)
	 * 
	 * @param path
	 *            包含文件的绝对路径.
	 * @return
	 */
	public static int deleteFileByDoc(String path) {
		path = path.replaceAll("/", "\\\\");
		path = path.replaceAll("\\\\\\\\", "\\\\");
		if (new File(path).exists()) {
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("cmd /c del " + path);
				return 0;
			} catch (IOException e) {
				return 1;
			}
		} else {
			return 2;
		}
	}

	/**
	 * 强制删除一个目录以及该目录下的子文件和目录(通过命令的方式删除)
	 * 
	 * @param path
	 *            文件的路径
	 * @return
	 */
	public static int deleteDirByDoc(String path) {
		path = path.replaceAll("/", "\\\\");
		path = path.replaceAll("\\\\\\\\", "\\\\");
		if (new File(path).exists()) {
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("cmd /c rd /s/q " + path);
				return 0;
			} catch (IOException e) {
				return 1;
			}
		} else {
			return 2;
		}
	}

	/**
	 * 文件删除
	 * 
	 * @param pathName
	 * @return
	 */
	public static int delete(String pathName) {
		return delete(new File(pathName));
	}

	/**
	 * 文件删除
	 * 
	 * @param pathName
	 * @return
	 */
	public static int delete(File filename) {
		if (filename.isFile()) {
			return deleteFileByDoc(filename.getAbsolutePath());
		} else {
			return deleteDirByDoc(filename.getAbsolutePath());
		}
	}

	/* [/文件删除结束] */

	/* [文件移动] */
	// 将文件移动一个目录下.
	public static int move(String sourceFile, String targetPath) {
		sourceFile = sourceFile.replaceAll("/", "\\\\");
		sourceFile = sourceFile.replaceAll("\\\\\\\\", "\\\\");

		targetPath = targetPath.replaceAll("/", "\\\\");
		targetPath = targetPath.replaceAll("\\\\\\\\", "\\\\");

		Runtime runtime = Runtime.getRuntime();
		if (new File(sourceFile).exists()) {
			try {
				runtime.exec("cmd /c move " + sourceFile + " " + targetPath);
				return 0;
			} catch (IOException e) {
				return 1;
			}
		} else {
			return 2;
		}
	}

	// 将文件移动一个目录下.
	public static int copy(String sourceFile, String targetPath) {
		sourceFile = sourceFile.replaceAll("/", "\\\\");
		sourceFile = sourceFile.replaceAll("\\\\\\\\", "\\\\");

		targetPath = targetPath.replaceAll("/", "\\\\");
		targetPath = targetPath.replaceAll("\\\\\\\\", "\\\\");

		Runtime runtime = Runtime.getRuntime();
		if (new File(sourceFile).exists()) {
			try {
				runtime.exec("cmd /c copy " + sourceFile + " " + targetPath);
				return 0;
			} catch (IOException e) {
				return 1;
			}
		} else {
			return 2;

		}
	}

	/* [/文件移动] */

	/**
	 * 打开系统记事本
	 * 
	 * @throws IOException
	 */
	public static void openSystemTxt() throws IOException {
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("notepad");
	}

	public static void openSystemTxt(String sourceFile) throws IOException {
		sourceFile = sourceFile.replaceAll("/", "\\\\");
		sourceFile = sourceFile.replaceAll("\\\\\\\\", "\\\\");
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("notepad " + sourceFile);
	}

	public static void executeBatFile(String batFile) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		runtime.exec(batFile);
	}

	public static void copyDirectory(File srcDir, File destDir)
			throws IOException {
		copyDirectory(srcDir, destDir, true);
	}

	public static void copyDirectory(File srcDir, File destDir,
			boolean preserveFileDate) throws IOException {
		copyDirectory(srcDir, destDir, null, preserveFileDate);
	}

	@SuppressWarnings("unchecked")
	public static void copyDirectory(File srcDir, File destDir,
			FileFilter filter, boolean preserveFileDate) throws IOException {
		if (srcDir == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destDir == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if (srcDir.exists() == false) {
			throw new FileNotFoundException("Source '" + srcDir
					+ "' does not exist");
		}
		if (srcDir.isDirectory() == false) {
			throw new IOException("Source '" + srcDir
					+ "' exists but is not a directory");
		}
		if (srcDir.getCanonicalPath().equals(destDir.getCanonicalPath())) {
			throw new IOException("Source '" + srcDir + "' and destination '"
					+ destDir + "' are the same");
		}

		// Cater for destination being directory within the source directory
		// (see IO-141)
		List exclusionList = null;
		if (destDir.getCanonicalPath().startsWith(srcDir.getCanonicalPath())) {
			File[] srcFiles = filter == null ? srcDir.listFiles() : srcDir
					.listFiles(filter);
			if (srcFiles != null && srcFiles.length > 0) {
				exclusionList = new ArrayList(srcFiles.length);
				for (int i = 0; i < srcFiles.length; i++) {
					File copiedFile = new File(destDir, srcFiles[i].getName());
					exclusionList.add(copiedFile.getCanonicalPath());
				}
			}
		}
		doCopyDirectory(srcDir, destDir, filter, preserveFileDate,
				exclusionList);
	}

	@SuppressWarnings("unchecked")
	private static void doCopyDirectory(File srcDir, File destDir,
			FileFilter filter, boolean preserveFileDate, List exclusionList)
			throws IOException {
		if (destDir.exists()) {
			if (destDir.isDirectory() == false) {
				throw new IOException("Destination '" + destDir
						+ "' exists but is not a directory");
			}
		} else {
			if (destDir.mkdirs() == false) {
				throw new IOException("Destination '" + destDir
						+ "' directory cannot be created");
			}
			if (preserveFileDate) {
				destDir.setLastModified(srcDir.lastModified());
			}
		}
		if (destDir.canWrite() == false) {
			throw new IOException("Destination '" + destDir
					+ "' cannot be written to");
		}
		File[] files = filter == null ? srcDir.listFiles() : srcDir
				.listFiles(filter);
		if (files == null) {
			throw new IOException("Failed to list contents of " + srcDir);
		}
		for (int i = 0; i < files.length; i++) {
			File copiedFile = new File(destDir, files[i].getName());
			if (exclusionList == null
					|| !exclusionList.contains(files[i].getCanonicalPath())) {
				if (files[i].isDirectory()) {
					doCopyDirectory(files[i], copiedFile, filter,
							preserveFileDate, exclusionList);
				} else {
					doCopyFile(files[i], copiedFile, preserveFileDate);
				}
			}
		}
	}

	private static void doCopyFile(File srcFile, File destFile,
			boolean preserveFileDate) throws IOException {
		if (destFile.exists() && destFile.isDirectory()) {
			throw new IOException("Destination '" + destFile
					+ "' exists but is a directory");
		}

		FileInputStream input = new FileInputStream(srcFile);
		try {
			FileOutputStream output = new FileOutputStream(destFile);
			try {
				IOUtils.copy(input, output);
			} finally {
				IOUtils.closeQuietly(output);
			}
		} finally {
			IOUtils.closeQuietly(input);
		}

		if (srcFile.length() != destFile.length()) {
			throw new IOException("Failed to copy full contents from '"
					+ srcFile + "' to '" + destFile + "'");
		}
		if (preserveFileDate) {
			destFile.setLastModified(srcFile.lastModified());
		}
	}

	public static void copyFileToDirectory(File srcFile, File destDir)
			throws IOException {
		copyFileToDirectory(srcFile, destDir, true);
	}

	public static void copyFileAll(String srcFile, String targetFile)
			throws Exception {
		File src_File = new File(srcFile);
		File tar_File = new File(targetFile);
		boolean isTargetFile = true;
		if (targetFile.substring(targetFile.lastIndexOf("/")).contains(".")) {
			isTargetFile = false;
		}
		if (src_File.isFile() && !isTargetFile) {
			copyFile(src_File, tar_File, true);
		} else if (src_File.isDirectory() && isTargetFile) {
			if (!tar_File.exists())
				tar_File.mkdirs();
			copyDirectory(src_File, tar_File);
		} else if (src_File.isFile() && isTargetFile) {
			if (!tar_File.exists())
				tar_File.mkdirs();
			copyFileToDirectory(src_File, tar_File);
		}
	}

	public static void copyFile(File srcFile, File destFile,
			boolean preserveFileDate) throws IOException {
		if (srcFile == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destFile == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if (srcFile.exists() == false) {
			throw new FileNotFoundException("Source '" + srcFile
					+ "' does not exist");
		}
		if (srcFile.isDirectory()) {
			throw new IOException("Source '" + srcFile
					+ "' exists but is a directory");
		}
		if (srcFile.getCanonicalPath().equals(destFile.getCanonicalPath())) {
			throw new IOException("Source '" + srcFile + "' and destination '"
					+ destFile + "' are the same");
		}
		if (destFile.getParentFile() != null
				&& destFile.getParentFile().exists() == false) {
			if (destFile.getParentFile().mkdirs() == false) {
				throw new IOException("Destination '" + destFile
						+ "' directory cannot be created");
			}
		}
		if (destFile.exists() && destFile.canWrite() == false) {
			throw new IOException("Destination '" + destFile
					+ "' exists but is read-only");
		}
		doCopyFile(srcFile, destFile, preserveFileDate);
	}

	public static void copyFileToDirectory(File srcFile, File destDir,
			boolean preserveFileDate) throws IOException {
		if (destDir == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if (destDir.exists() && destDir.isDirectory() == false) {
			throw new IllegalArgumentException("Destination '" + destDir
					+ "' is not a directory");
		}
		copyFile(srcFile, new File(destDir, srcFile.getName()),
				preserveFileDate);
	}

	/* ExmayFileCount.java */
	/**
	 * 统计文档的数量
	 * 
	 * @param file
	 * @return
	 */
	public static int count(String dirPath) {
		return count(new File(dirPath));
	}

	/**
	 * 统计文档的数量
	 * 
	 * @param file
	 * @return
	 */
	public static int count(File file) {
		if (file.exists()) {
			if (file.isDirectory()) {
				String[] files = file.list();
				if (files.length == 0) {
					return 0;
				} else {
					int filenum = 0;
					for (int i = 0; i < files.length; i++) {
						filenum += count(new File(file, files[i]));
					}
					return filenum;
				}
			} else {
				return 1;
			}
		} else {
			return 0;
		}
	}

	public long getlist(File f) {// 递归求取目录文件个数
		long size = 0;
		File flist[] = f.listFiles();
		size = flist.length;
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getlist(flist[i]);
				size--;
			}
		}
		return size;
	}

	/* [/ExmayFileCount.java] */

	/* [ExmayFileCountSize.java] */
	/**
	 * 统计文件大小
	 * 
	 * @param pathname
	 * @return
	 */
	public static String countFileSize(String pathname) {
		String fileSizeString = "";
		try {
			File file = new File(pathname);
			DecimalFormat df = new DecimalFormat("#.00");
			long fileS = file.length();
			if (fileS < 1024) {
				fileSizeString = "0byte";
			} else if (fileS < 1048576) {
				fileSizeString = df.format((double) fileS / 1024) + "KB";
			} else if (fileS < 1073741824) {
				fileSizeString = df
						.format(((double) fileS / 1024 / 1024) - 0.01)
						+ "MB";
			} else {
				fileSizeString = df.format((double) fileS / 1024 / 1024 / 1024)
						+ "G";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileSizeString;
	}

	/**
	 * 根据File文件的长度统计文件的大小
	 * 
	 * @param size
	 *            File的长度 file.lenght()
	 * @return 返回文件大小
	 */
	public static String countFileSize(long fileSize) {
		String fileSizeString = "";
		try {
			DecimalFormat df = new DecimalFormat("#.00");
			long fileS = fileSize;
			if (fileS == 0) {
				fileSizeString = "0KB";
			} else if (fileS < 1024) {
				fileSizeString = df.format((double) fileS) + "B";
			} else if (fileS < 1048576) {
				fileSizeString = df.format((double) fileS / 1024) + "KB";
			} else if (fileS < 1073741824) {
				fileSizeString = df
						.format(((double) fileS / 1024 / 1024) - 0.01)
						+ "MB";
			} else {
				fileSizeString = df.format((double) fileS / 1024 / 1024 / 1024)
						+ "G";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileSizeString;
	}

	/**
	 * 根据File文件的长度统计文件的大小
	 * 
	 * @param size
	 *            File的长度 file.lenght()
	 * @return 返回文件大小
	 */
	public static String byteCountToDisplaySize(long size) {
		String displaySize;
		if (size / ONE_GB > 0) {
			displaySize = String.valueOf(size / ONE_GB) + " G";
		} else if (size / ONE_MB > 0) {
			displaySize = String.valueOf(size / ONE_MB) + " MB";
		} else if (size / ONE_KB > 0) {
			displaySize = String.valueOf(size / ONE_KB) + " KB";
		} else {
			displaySize = String.valueOf(size) + " bytes";
		}
		return displaySize;
	}

	/**
	 * 递归获取目录的大小
	 * 
	 * @param directory
	 *            目录
	 * @return 返回目录大小
	 */
	public static long sizeofDirectory(File directory) {
		return FileUtils.sizeOfDirectory(directory);
	}

	/**
	 * 递归获取目录的大小
	 * 
	 * @param directory
	 *            目录
	 * @return 返回目录大小
	 */
	public static long sizeofDirectory(String directory) {
		return sizeOfDirectory(new File(directory));
	}

	/**
	 * 统计一个文件夹的大小
	 * 
	 * @param directory
	 * @return
	 */
	public static long sizeOfDirectory(File directory) {
		if (!directory.exists()) {
			throw new IllegalArgumentException(directory + " does not exist");
		}
		if (!directory.isDirectory()) {
			throw new IllegalArgumentException(directory
					+ " is not a directory");
		}

		long size = 0;

		File[] files = directory.listFiles();
		if (files == null) {
			return 0L;
		}
		for (int i = 0; i < files.length; i++) {
			File file = files[i];

			if (file.isDirectory()) {
				size += sizeOfDirectory(file);
			} else {
				size += file.length();
			}
		}
		return size;
	}

	/**
	 *统计MP3文件时长方法
	 * 
	 * @param mp3File
	 *            音频文件
	 * @return
	 */
//	public static String sizeOfMp3(String mp3File) {
//		return sizeOfMp3(new File(mp3File));
//	}

//	public static String sizeOfMp3(File mp3File) {
//		if (!mp3File.exists())
//			return "";
//		StringBuffer buffer = new StringBuffer();
//		if (getExtNoPoint(mp3File.getName()).equals("mp3")) {
//			try {
//				FileInputStream fis = new FileInputStream(mp3File);
//				int b = fis.available();
//				Bitstream bt = new Bitstream(fis);
//				Header h = bt.readFrame();
//				int time = (int) h.total_ms(b);
//
//				int i = time / 1000;
//				String m = "";
//				String s = "";
//				if ((i / 60) < 10) {
//					m = "0" + i / 60 + ":";
//				} else {
//					m = i / 60 + ":";
//				}
//				if (i % 60 < 10) {
//					s = "0" + i % 60;
//				} else {
//					s = i % 60 + "";
//				}
//				buffer.append(m + s);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			buffer.append("00:00");
//		}
//		return buffer.toString();
//	}

	/* [/ExmayFileCountSize.java] */

	/* [ExmayFileCreate.java] */
	/**
	 * 新建文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String 文件内容
	 * @return boolean
	 */
	public static void newFile(String filePathAndName, String fileContent) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			resultFile.close();
		} catch (Exception e) {
			System.out.println("新建目录操作出错");
			e.printStackTrace();

		}
	}

	public static void createFile(String path, boolean isFile) {
		createFile(new File(path), isFile);
	}

	public static void createFile(File file, boolean isFile) {
		if (!file.exists() && file.isFile()) {
			if (!file.getParentFile().exists()) {
				createFile(file.getParentFile(), false);
			} else {
				if (isFile) {
					try {
						file.mkdirs();
						file.createNewFile();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			file.mkdirs();
		}
	}

	/**
	 * 新建目录
	 * 
	 * @param folderPath
	 *            String 如 c:/fqf
	 * @return boolean
	 */
	public static int createFloder(String folderPath) {
		try {
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if(myFilePath.isFile()){
				myFilePath.getParentFile().mkdirs();
				return 0;
			}else{
				if (!myFilePath.exists()) {
					myFilePath.mkdirs();
					return 0;
				} else {
					return 1;
				}
			}
		} catch (Exception e) {
			return 2;
		}
	}

	/**
	 * 新建文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String 文件内容
	 * @return int 0 成功 1 文件存在 2 失败
	 */
	public static int createFile(String filePathAndName, String fileContent) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				// 创建父目录
				createFloder(myFilePath.getParent());
			} else {
				return 1;
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			resultFile.close();
			return 0;
		} catch (Exception e) {
			return 2;
		}
	}

	/* [/ExmayFileCreate.java] */

	/* [ExmayFileDownNetFile.java] */
	// 根据一个图片的url，通过url的方式保存到本地。
	public static boolean downImg(String filePath, String imageUrl,
			String fileName) {
		try {
			File files = new File(filePath);
			if (!files.exists()) {
				files.mkdirs();
			}
			URL url = new URL(imageUrl);
			URLConnection con = url.openConnection();
			InputStream is = con.getInputStream();
			if (!filePath.endsWith("/")) {
				filePath = filePath + "/";
			}
			File file = new File(filePath + fileName);
			FileOutputStream out = new FileOutputStream(file);
			int i = 0;
			while ((i = is.read()) != -1) {
				out.write(i);
			}
			is.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 根据一个图片的url，通过url的方式保存到本地。
	public static Map<String, Object> downPicture(String filePath,
			String imageUrl, String fileName) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer size = null;
		String mime = null;
		try {
			File files = new File(filePath);
			if (!files.exists()) {
				files.mkdirs();
			}
			URL url = new URL(imageUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			InputStream is = connection.getInputStream();
			if (!filePath.endsWith("/")) {
				filePath = filePath + "/";
			}
			File file = new File(filePath + fileName);
			FileOutputStream out = new FileOutputStream(file);
			int i = 0;
			while ((i = is.read()) != -1) {
				out.write(i);
			}
			size = connection.getContentLength();
			mime = connection.getContentType();
			is.close();
		} catch (Exception e) {

		}
		map.put("size", size);
		map.put("mime", mime);
		return map;
	}

	public static int getLength(String htmlUrl) throws IOException {
		URL url = new URL(htmlUrl);
		URLConnection con = url.openConnection();
		return con.getContentLength();
	}

	public static String downNetImg(String filePath,String remotePath, String htmlUrl,
			String fileName) {
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		URL url = null;
		OutputStream os = null;
		try {
			url = new URL(htmlUrl);
			URLConnection con = url.openConnection();
			int lenss = con.getContentLength();
			InputStream is = url.openStream();
			os = new FileOutputStream(filePath + fileName);
			int length = 0;
			byte[] buffer = new byte[5 * 1024];
			int len = 0;
			while ((length = is.read(buffer, 0, 5 * 1024)) != -1) {
				len = length + len;
				double percent = Math.round((len / (double) lenss) * 100D);
				os.write(buffer, 0, length);
			}
			return remotePath + fileName;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getNetFileSize(String urlFile) {
		URL url;
		try {
			url = new URL(urlFile);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			return connection.getContentType();
		} catch (Exception e) {
			return "";
		}
	}

	public static String getMineType(String urlFile) {
		URL url;
		try {
			url = new URL(urlFile);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			return countFileSize(connection.getContentLength());
		} catch (Exception e) {
			return "0";
		}
	}

	public static void supportURLType(String host, String file) {
		String[] schemes = { "http", "https", "ftp", "mailto", "telent",
				"file", "ldap", "gopher", "jdbc", "rmi", "jar", "doc",
				"netdoc", "nfs", "verbatim", "finger", "daytime",
				"systemresouce" };
		for (int i = 0; i < schemes.length; i++) {
			try {
				@SuppressWarnings("unused")
				URL url = new URL(schemes[i], host, file);
				System.out.println(schemes[i] + "是Java所支持的URL类型\r\n");
			} catch (Exception e) {
				System.out.println(schemes[i] + "不是Java所支持的URL类型\r\n");
			}
		}
	}

	/* [/ExmayFileDownNetFile.java] */

	/* [ExmayFileEncodingTransfer.java] */
	/**
	 * xiaoer 文本文件转换为制定编码的字符串?记得要做成批量的。尚未完成。
	 * 
	 * @param filePath
	 *            文件的路径含有文件.
	 * @param encoding
	 *            要转换后的编码.
	 * @return
	 */
	public static String fileToString(String filePath, String encoding) {
		InputStreamReader reader = null;
		StringWriter writer = new StringWriter();
		try {
			if (encoding == null || "".equals(encoding)) {
				reader = new InputStreamReader(new FileInputStream(new File(
						filePath)), encoding);
			} else {
				reader = new InputStreamReader(new FileInputStream(new File(
						filePath)));
			}
			char[] buffer = new char[1024];
			int n = 0;
			while (-1 != (n = reader.read(buffer))) {
				writer.write(buffer, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}
		if (writer != null) {
			return writer.toString();
		} else {
			return null;
		}
	}

	/* [/ExmayFileEncodingTransfer.java] */

	/* [ExmayFileList.java] */
	public static final String[] EXMAY_IMAGE_EXT = new String[] { "jpg",
			"jpeg", "gif", "png", "bmp" };

	/**
	 * 返回一个文件夹一级的调用方法
	 * 
	 * @param file
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public static List<String> getDirectoryFirstFiles(String path) {
		List<String> list = new ArrayList<String>();
		File file = new File(path);
		if (file.isFile()) {
			list.add(file.getAbsolutePath());
			return list;
		}
		File[] files = file.listFiles();
		sort(files);
		for (File file2 : files) {
			list.add(file2.getAbsolutePath());
		}

		Set set = new HashSet();
		List newList = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		list.clear();
		list.addAll(newList);
		return list; // 将ArrayList集合对象返回list
	}

	/**
	 * 是否是图片
	 * 
	 * @param ext
	 * @return "jpg", "jpeg", "gif", "png", "bmp" 为文件后缀名者为图片
	 */
	public static boolean isValidImage(String ext) {
		for (String s : EXMAY_IMAGE_EXT) {
			if (s.equalsIgnoreCase(ext)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取需要过滤的后缀
	 * 
	 * @param fileTypes
	 *            从数据库获取的后缀
	 * @return
	 */
	public static String[] getFileExts(String fileTypes) {
		if (fileTypes.indexOf(";") == -1) {
			return new String[] { fileTypes };
		}
		String[] exts = fileTypes.split(";");
		String[] fileExts = new String[exts.length];
		for (int i = 0; i < exts.length; i++) {
			fileExts[i] = getExtNoPoint(exts[i]);
		}
		return fileExts;
	}

	public static void sort(File[] files) {
		Arrays.sort(files, new Comparator<File>() {
			public int compare(File file1, File file2) {
				long diff = file1.lastModified() - file2.lastModified();
				if (diff > 0)
					return -1;
				else if (diff == 0)
					return 0;
				else
					return 1;
			}
		});
	}

	/**
	 * 获取当前目录下的目录和文件（名称）
	 * 
	 * @param path
	 * @return
	 */
	public static List<String> getDirectoryAndFile(String path) {
		List<String> list = new ArrayList<String>();
		File file = new File(path);
		if (file.isFile()) {
			list.add(file.getName());
			return list;
		}
		File[] files = file.listFiles();
		/** 按文件的修改时间排序 **/
		sort(files);
		for (File file2 : files) {
			list.add(file2.getName());
		}
		return list; // 将ArrayList集合对象返回list
	}

	/**
	 * 获取当前目录下的目录和文件（绝对路径）
	 * 
	 * @param path
	 * @return
	 */
	public static List<String> getDirAbsolutePathAndFile(String path) {
		List<String> list = new ArrayList<String>();
		File file = new File(path);
		if (file.isFile()) {
			list.add(file.getAbsolutePath());
			return list;
		}
		File[] files = file.listFiles();
		sort(files);
		for (File file2 : files) {
			list.add(file2.getAbsolutePath());
		}
		return list;
	}

	/**
	 * 获取当前目录下属于exts后缀的文件名。不包含目录名
	 * 
	 * @param path
	 * @param exts
	 * @return
	 */
	public static List<String> getDirectoryFileNameByExt(String path,
			String[] exts) {
		List<String> list = new ArrayList<String>();
		for (String file : getDirAbsolutePathAndFile(path)) {
			if (new File(file).isFile()) {
				String suffix = getExtNoPoint(file);
				String filename = getFileName(file);
				for (String ext : exts) {
					if (suffix.equalsIgnoreCase(ext)) {
						list.add(filename);
					}
				}
			}
		}
		return list;
	}

	/**
	 * 获取当前目录下的目录名称和文件名称
	 * 
	 * @param dir
	 * @return
	 */
	public static String[] getDirectoryFirstFileAndDIR(String dir) {
		return new File(dir).list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.charAt(0) != '.';
			}
		});
	}

	/**
	 * 获取一个文件下的第一级目录名称和文件名
	 * 
	 * @param path
	 * @return
	 */
	public static List<String> getFirstDirAndFile(String path) {
		List<String> list = new ArrayList<String>();
		File file = new File(path);
		File[] files = file.listFiles();
		for (File file2 : files) {
			if (file2.isDirectory()) {
				list.add(file2.getAbsolutePath().replaceAll(" ", "_"));
				renameFile(file2.getAbsolutePath(), file2.getAbsolutePath()
						.replaceAll(" ", "_"));
			} else {
				renameFile(file2.getAbsolutePath(), file2.getAbsolutePath()
						.replaceAll(" ", "_"));
				list.add(file2.getAbsolutePath().replaceAll(" ", "_"));
			}
		}
		return list;
	}

	

	public static long getDeleteTime(String filePath) {
		Pattern pattern = Pattern.compile("\\[exmay-delete-(\\d*)\\]");
		Matcher matcher = pattern.matcher(filePath);
		if (matcher.find()) {
			return Long.parseLong(matcher.group(1));
		}
		return 0;
	}

	public  String getFirstFile(String filepath) {
		List<String> list = listFiles(filepath, "all");
		return list.get(0);
	}

	// 获取磁盘所有文件方法
	public static List<String> collectionsFiles(String path) {
		LinkedList<File> list = new LinkedList<File>();
		ArrayList<String> listPath = new ArrayList<String>();
		File dir = new File(path);
		File file[] = dir.listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isDirectory()) {
				list.add(file[i]);
			} else {
				listPath.add(file[i].getAbsolutePath());
			}
		}
		File tmp;
		while (!list.isEmpty()) {
			tmp = list.removeFirst();
			if (tmp.isDirectory()) {
				file = tmp.listFiles();
				if (file == null) {
					continue;
				}
				for (int i = 0; i < file.length; i++) {
					if (file[i].isDirectory()) {
						list.add(file[i]);
					} else {
						listPath.add(file[i].getAbsolutePath());
					}
				}
			}
		}
		return listPath;
	}

	/**
	 * 获取当前目录下的文件夹名称 docs<br>
	 * lib<br>
	 * META-INF<br>
	 * ooxml-lib<br>
	 * org<br>
	 * 
	 * @param filepath
	 * @return
	 */
	public static List<String> getDirName(String filepath) {
		List<String> directorys = new ArrayList<String>();
		File file = new File(filepath);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				directorys.add(files[i].getName());
			}
		}
		return directorys;
	}

	/**
	 * 返回当前目录下的文件名(绝对路径)
	 * 
	 * @param file
	 *            D:\poi-bin-3.8-beta2-20110408\poi-3.8-beta2\docs
	 *            D:\poi-bin-3.8-beta2-20110408\poi-3.8-beta2\lib
	 *            D:\poi-bin-3.8-beta2-20110408\poi-3.8-beta2\META-INF
	 *            D:\poi-bin-3.8-beta2-20110408\poi-3.8-beta2\ooxml-lib
	 *            D:\poi-bin-3.8-beta2-20110408\poi-3.8-beta2\org
	 * @return
	 */
	public static List<String> getDirAbsolutePath(String path) {
		List<String> list = new ArrayList<String>();
		File file = new File(path);
		if (file.isFile()) {
			list.add(file.getAbsolutePath());
			return list;
		}
		File[] files = file.listFiles();
		sort(files);
		for (File file2 : files) {
			if (file2.isDirectory()) {
				list.add(file2.getAbsolutePath());
			}
		}

		return list;
	}

	/**
	 * 递归回去当前目录下所有的目录名和子目录名（绝对路径）
	 * 
	 * @param path
	 * @return
	 */
	private  StringBuffer pathBuffer = new StringBuffer("");
	public  String[] getDirPath(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			pathBuffer.append(file.getAbsolutePath() + "@sep@");
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					getDirPath(files[i].getAbsolutePath());
				}
			}
		}
		
		String[] strings = pathBuffer.toString().split("@sep@");
		return strings;
	}

	/**
	 * 获取当前目录下的目录和文件(绝对路径)
	 * 
	 * @param path
	 *            路径
	 * @return
	 */
	private StringBuffer dirsBuffer = new StringBuffer("");
	public  String[] listDirAndFiles(String path) {
		File file = new File(path);
		dirsBuffer.append(file.getAbsolutePath() + "@sep@");
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				listDirAndFiles(files[i].getPath());
			}
		}
		String[] strings = dirsBuffer.toString().split("@sep@");
		return strings;
	}

	/**
	 * 获取当前目录下所有文件
	 * 
	 * @param path
	 *            路径
	 * @return
	 */
	private  StringBuffer filesBuffer = new StringBuffer("");
	public  String[] listFiles(String path) {
		File file = new File(path);
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				listFiles(files[i].getPath());
			}
		}else{
			filesBuffer.append(file.getAbsolutePath() + "@sep@");
		}
		String[] strings = filesBuffer.toString().split("@sep@");
		return strings;
	}

	private  StringBuffer listBuffer = new StringBuffer("");
	public  String[] listFiles(File file) {
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				listFiles(files[i]);
			}
		}else{
			listBuffer.append(file.getAbsolutePath()+"@sep@");
		}
		String s = listBuffer.toString();
		String[] list = s.split("@sep@");
		return list;
	}
	/**
	 * 根据后缀过滤你要获取的文件
	 * 
	 * @param path
	 * @param type
	 *            文件后缀
	 * @return
	 */
	public static  List<String> listFiles(String path, String type) {
		LinkedList<File> list = new LinkedList<File>();
		ArrayList<String> listPath = new ArrayList<String>();
		File dir = new File(path);
		if (!dir.exists()) {
			return Collections.EMPTY_LIST;
		}
		File file[] = dir.listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isDirectory()) {
				list.add(file[i]);
			} else {
				if (type == null || type.equals("") || type.equals("all")) {
					listPath.add(file[i].getAbsolutePath());
				}

				if (getExtNoPoint(file[i].getName()).equals(type)) {
					listPath.add(file[i].getAbsolutePath());
				}
			}
		}

		File tmp;
		while (!list.isEmpty()) {
			tmp = list.removeFirst();
			if (tmp.isDirectory()) {
				file = tmp.listFiles();
				if (file == null) {
					continue;
				}
				for (int i = 0; i < file.length; i++) {
					if (file[i].isDirectory()) {
						list.add(file[i]);
					} else {
						if (type == null || type.equals("")
								|| type.equals("all")) {
							listPath.add(file[i].getAbsolutePath());
						}
						if (getExtNoPoint(file[i].getName()).equals(type)) {
							listPath.add(file[i].getAbsolutePath());
						}
					}
				}
			}
		}
		return listPath;
	}

	/**
	 * 根据后缀过滤你要获取的文件
	 * 
	 * @param path
	 * @param type
	 *            文件后缀
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> listFiles(String path, String[] exts) {
		if (exts == null || exts.length == 0)
			return Collections.EMPTY_LIST;
		LinkedList<File> list = new LinkedList<File>();
		ArrayList<String> listPath = new ArrayList<String>();
		File dir = new File(path);
		if (!dir.exists()) {
			return Collections.EMPTY_LIST;
		}
		File file[] = dir.listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isDirectory()) {
				list.add(file[i]);
			} else {
				for (String ext : exts) {
					if (getExtNoPoint(file[i].getName()).equalsIgnoreCase(ext)) {
						listPath.add(file[i].getAbsolutePath());
					}
				}
			}
		}

		File tmp;
		while (!list.isEmpty()) {
			tmp = list.removeFirst();
			if (tmp.isDirectory()) {
				file = tmp.listFiles();
				if (file == null) {
					continue;
				}
				for (int i = 0; i < file.length; i++) {
					if (file[i].isDirectory()) {
						list.add(file[i]);
					} else {
						for (String ext : exts) {
							if (getExtNoPoint(file[i].getName())
									.equalsIgnoreCase(ext)) {
								listPath.add(file[i].getAbsolutePath());
							}
						}
					}
				}
			}
		}
		return listPath;
	}

	/* [/ExmayFileList.java] */

	public static void moveDirectory(File srcDir, File destDir)
			throws IOException {
		if (srcDir == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destDir == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if (!srcDir.exists()) {
			throw new FileNotFoundException("Source '" + srcDir
					+ "' does not exist");
		}
		if (!srcDir.isDirectory()) {
			throw new IOException("Source '" + srcDir + "' is not a directory");
		}
		if (destDir.exists()) {
			throw new IOException("Destination '" + destDir
					+ "' already exists");
		}
		boolean rename = srcDir.renameTo(destDir);
		if (!rename) {
			copyDirectory(srcDir, destDir);
			deleteDirectory(srcDir);
			if (srcDir.exists()) {
				throw new IOException("Failed to delete original directory '"
						+ srcDir + "' after copy to '" + destDir + "'");
			}
		}
	}

	public static void moveDirectoryToDirectory(File src, File destDir,
			boolean createDestDir) throws IOException {
		if (src == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destDir == null) {
			throw new NullPointerException(
					"Destination directory must not be null");
		}
		if (!destDir.exists() && createDestDir) {
			destDir.mkdirs();
		}
		if (!destDir.exists()) {
			throw new FileNotFoundException("Destination directory '" + destDir
					+ "' does not exist [createDestDir=" + createDestDir + "]");
		}
		if (!destDir.isDirectory()) {
			throw new IOException("Destination '" + destDir
					+ "' is not a directory");
		}
		moveDirectory(src, new File(destDir, src.getName()));

	}

	public static void moveFile(File srcFile, File destFile) throws Exception {
		if (srcFile == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destFile == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if (!srcFile.exists()) {
			throw new FileNotFoundException("Source '" + srcFile
					+ "' does not exist");
		}
		if (srcFile.isDirectory()) {
			throw new IOException("Source '" + srcFile + "' is a directory");
		}
		if (destFile.exists()) {
			throw new IOException("Destination '" + destFile
					+ "' already exists");
		}
		if (destFile.isDirectory()) {
			throw new IOException("Destination '" + destFile
					+ "' is a directory");
		}
		boolean rename = srcFile.renameTo(destFile);
		if (!rename) {
			copyFile(srcFile, destFile, true);
			if (!srcFile.delete()) {
				deleteQuietly(destFile);
				throw new IOException("Failed to delete original file '"
						+ srcFile + "' after copy to '" + destFile + "'");
			}
		}
	}

	/**
	 * 移动文件到指定目录
	 * 
	 * @param oldPath
	 *            String 如：c:/fqf.txt
	 * @param newPath
	 *            String 如：d:/fqf.txt
	 * @throws IOException
	 */
	public static void moveFile(String oldPath, String newPath)
			throws IOException {
		copyFile(new File(oldPath), new File(newPath), true);
		delFile(oldPath);
	}

	public static void moveFolder(String oldPath, String newPath)
			throws IOException {
		copyDirectory(new File(oldPath), new File(newPath));
		delFolder(oldPath);
	}

	public static void fileMove(String from, String to) throws Exception {
		try {
			File dir = new File(from);
			// 将文件或者文件夹放入文件集中
			File[] files = dir.listFiles();
			if (files == null) {
				return;
			}
			File moveDir = new File(to);
			// 判断目标目录是否存在
			if (!moveDir.exists()) {
				moveDir.mkdirs();// 不存在则创建
			}
			// 遍历文件集
			for (int i = 0; i < files.length; i++) {
				// 如果是文件夹或者是目录，则递归调用fileMove的方法，知道获取目录下的文件
				if (files[i].isDirectory()) {
					// 递归移动文件
					fileMove(files[i].getPath(), to + "\\" + files[i].getName());
					// 删除文件所在源目录
					files[i].delete();
				}
				// 将文件目录放入移动后的目录
				File moveFile = new File(moveDir.getPath() + "\\"
						+ files[i].getName());
				if (moveFile.exists()) {
					// 如果目标文件下，已经存在该文件夹或者目录了，先删除.
					moveFile.delete();
				}
				// 移动文件
				files[i].renameTo(moveFile);
			}
		} catch (Exception e) {

		}
	}

	public static String genPathName() {
		return pathDf.format(new Date());
	}

	/**
	 * 获取一个文件的后缀(带有点)
	 * 
	 * @param fileName
	 *            文件名
	 * @return 返回文件的后缀
	 */
	public static String getExt(String fileName) {
		int pos = fileName.lastIndexOf(".");
		if (pos == -1)
			return "";
		return fileName.substring(pos, fileName.length());
	}

	/**
	 * 获取一个文件的后缀(不带有点)
	 * 
	 * @param fileName
	 *            文件名
	 * @return 返回文件的后缀
	 */
	public static String getExtNoPoint(String fileName) {
		if (fileName.lastIndexOf(".") == -1)
			return "";
		int pos = fileName.lastIndexOf(".") + 1;
		return fileName.substring(pos, fileName.length());
	}

	/**
	 * 获取一个文件最后一个斜线前的内容(带有点)
	 * resource/system/upload/xuchengfeifei/2011/01/01/20110101144251319.jpg ==
	 * >resource/system/upload/xuchengfeifei/2011/01/01/20110101144251319
	 * 
	 * @param fileName
	 *            文件名
	 * @return 返回文件的后缀
	 */
	public static String getName(String fileName) {
		int pos = fileName.lastIndexOf(".");
		if (pos == -1) {
			return fileName;
		} else {
			return fileName.substring(0, pos);
		}
	}

	/**
	 * 获取一个文件的文件名(带有后缀)
	 * resource/system/upload/xuchengfeifei/2011/01/01/20110101144251319.jpg ==
	 * >20110101144251319.jpg
	 * 
	 * @param fileName
	 *            文件
	 * @return 返回文件的文件名
	 */
	public static String getFileName(String fileName) {
		fileName = transfer(fileName);
		int pos = fileName.lastIndexOf("/") + 1;
		if (pos == -1) {
			return fileName;
		} else {
			return fileName.substring(pos, fileName.length());
		}
	}

	private static String transfer(String fileName) {
		if (fileName.indexOf("\\") != -1) {
			fileName = fileName.replaceAll("\\\\", "/");
		}
		return fileName;
	}

	/**
	 * 获取一个文件的文件名(带有不带后缀)
	 * resource/system/upload/xuchengfeifei/2011/01/01/20110101144251319.jpg ==
	 * >20110101144251319
	 * 
	 * @param fileName
	 *            文件
	 * @return 返回文件的文件名
	 */
	public static String getNotExtName(String fileName) {
		fileName = transfer(fileName);
		String fString = getFileName(fileName);
		if (fString.lastIndexOf(".") != -1) {
			return fString.substring(0, fString.lastIndexOf("."));
		} else {
			return fString;
		}
	}

	/**
	 * 获取一个文件的文件名(带有不带后缀) resource/system/upload/xuchengfeifei/2011/01/01 <br>=
	 * = >resource/system/upload/xuchengfeifei/2011/01<br>
	 * resource/system/upload/xuchengfeifei/2011/01/01/ ==<br>
	 * resource/system/upload/xuchengfeifei/2011/01/01/ * @param fileName 文件
	 * 
	 * @return 返回文件的文件名
	 */
	public static String getLastShap(String fileName, int count) {
		fileName = transfer(fileName);
		if (fileName.lastIndexOf("/") != -1) {
			return fileName.substring(count, fileName.lastIndexOf("/"));
		} else {
			return fileName;
		}
	}

	public static String getLastShap(String fileName, int count, String pattern) {
		fileName = transfer(fileName);
		if (fileName.lastIndexOf(pattern) != -1) {
			return fileName.substring(count, fileName.lastIndexOf(pattern));
		} else {
			return fileName.substring(count, fileName.length());
		}
	}

	/**
	 * 返回一个文件除了文件名以前的路径(不带有最好斜线)
	 * resource/system/upload/xuchengfeifei/2011/01/01/20110101144251319.jpg <br>=
	 * =转换后<br>
	 * resource/system/upload/xuchengfeifei/2011/01/01 <br>
	 * 如果是：resource/system/upload/xuchengfeifei/2011/01/01
	 * ==resource/system/upload/xuchengfeifei/2011/01
	 * 
	 * @param pathName
	 *            文件路径+文件名
	 * @return
	 */
	public static String getLastBeforePath(String pathName) {
		pathName = transfer(pathName);
		if (pathName.lastIndexOf("/") != -1) {
			pathName = pathName.substring(0, pathName.length() - 1);
		}
		pathName = pathName.substring(0, pathName.lastIndexOf("/"));
		return pathName;
	}


	private static String getEntryName(String baseDirPath, File file) {
		if (!baseDirPath.endsWith(File.separator)) {
			baseDirPath += File.separator;
		}
		// 获取绝对路径
		String filepath = file.getAbsolutePath();
		if (file.isDirectory()) {
			filepath += "/";
		}
		int index = filepath.indexOf(baseDirPath);
		return filepath.substring(index + baseDirPath.length());
	}


	private static String conversionSpecialCharacters(String string) {
		return string.replaceAll("\\\\", "/");
	}

	public static boolean renameFile(String path, String oldname, String newname) {
		boolean result = false;
		if (!oldname.equals(newname)) {// 新的文件名和以前文件名不同时,才有必要进行重命名
			File oldfile = new File(path + "/" + oldname);
			File newfile = new File(path + "/" + newname);
			if (newfile.exists())// 若在该目录下已经有一个文件和新文件名相同，则不允许重命名
				result = false;
			else {
				oldfile.renameTo(newfile);
				result = true;
			}

		}
		return result;
	}

	public static boolean renameFile(String oldname, String newname) {
		boolean result = false;
		if (!oldname.equals(newname)) {// 新的文件名和以前文件名不同时,才有必要进行重命名
			File oldfile = new File(oldname);
			File newfile = new File(newname);
			if (newfile.exists())// 若在该目录下已经有一个文件和新文件名相同，则不允许重命名
				result = false;
			else {
				oldfile.renameTo(newfile);
				result = true;
			}

		}
		return result;
	}

	// 重命名
	public static boolean rename(String filepath, String fname, String newname) {
		File fl = new File(filepath); // 这里写上发替换的文件夹路径,注意使用双斜杠
		if (!fl.exists() || !fl.isDirectory()) {
			return false;
		}
		String[] files = fl.list();
		File f = null;
		String filename = "";
		for (String file : files) {
			f = new File(fl, file);// 注意,这里一定要写成File(fl,file)如果写成File(file)是行不通的,一定要全路径
			filename = f.getName();
			f.renameTo(new File(fl.getAbsolutePath() + "\\"
					+ filename.replace(fname, newname)));// 这里可以反复使用replace替换,当然也可以使用正则表达式来替换了

		}
		return true;
	}

	public static File[] searchFile(String file, String key) {
		return searchFile(new File(file), key);
	}

	@SuppressWarnings("unchecked")
	public static File[] searchFile(File folder, final String keyWord) {// 递归查找包含关键字的文件
		File[] subFolders = folder.listFiles(new FileFilter() {// 运用内部匿名类获得文件
					public boolean accept(File pathname) {// 实现FileFilter类的accept方法
						if (pathname.isFile())// 如果是文件
							countFiles++;
						else
							// 如果是目录
							countFolders++;
						if (pathname.isDirectory()
								|| (pathname.isFile() && pathname.getName()
										.contains(keyWord)))// 目录或文件包含关键字
							return true;
						return false;
					}
				});
		List result = new ArrayList();// 声明一个集合
		for (int i = 0; i < subFolders.length; i++) {// 循环显示文件夹或文件
			if (subFolders[i].isFile()) {// 如果是文件则将文件添加到结果列表中
				result.add(subFolders[i]);
			} else {// 如果是文件夹，则递归调用本方法，然后把所有的文件加到结果列表中
				File[] foldResult = searchFile(subFolders[i], keyWord);
				for (int j = 0; j < foldResult.length; j++) {// 循环显示文件
					result.add(foldResult[j]);// 文件保存到集合中
				}
			}
		}
		File files[] = new File[result.size()];// 声明文件数组，长度为集合的长度
		result.toArray(files);// 集合数组化
		return files;
	}

	String Filename = null;
	long FileSize = 0;
	long BlockNum = 0;

	private void getFileAttribute(String fileAndPath) {
		File file = new File(fileAndPath);
		Filename = file.getName();
		FileSize = file.length();
	}

	private long getBlockNum(long blockSize) {
		long fileSize = FileSize;
		if (fileSize <= blockSize) {
			return 1;
		} else {
			if (fileSize % blockSize > 0) {
				return (fileSize / blockSize) + 1;
			} else {
				return fileSize / blockSize;
			}
		}
	}

	@SuppressWarnings("unused")
	private String generateSeparatorFileName(String fileAndPath,
			int currentBlock) {
		String separatorFile = fileAndPath + ".part" + currentBlock;
		System.out.println("文件拆分成：" + separatorFile);
		return separatorFile;
	}

	@SuppressWarnings("unused")
	private boolean writeFile(String fileAndPath, String fileSeparateName,
			long blockSize, long beginPos) {
		RandomAccessFile raf = null;
		FileOutputStream fos = null;
		byte[] bt = new byte[2048];
		long writeByte = 0;
		int len = 0;
		try {
			raf = new RandomAccessFile(fileAndPath, "r");
			raf.seek(beginPos);
			fos = new FileOutputStream(fileSeparateName);
			while ((len = raf.read(bt)) > 0) {
				if (writeByte < blockSize) {
					writeByte = writeByte + len;
					if (writeByte <= blockSize) {
						fos.write(bt, 0, len);
					} else {
						len = len - (int) (writeByte - blockSize);
					}
				}
			}
			fos.close();
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
			}
			return false;
		}
		return true;
	}

	public boolean separatoFile(String fileAndPath, long blockSize) {
		getFileAttribute(fileAndPath);
		BlockNum = getBlockNum(blockSize);
		System.out.println("共拆分成" + BlockNum + "个文件");
		if (BlockNum == 1) {
			blockSize = FileSize;
		}
		@SuppressWarnings("unused")
		long writeSize = 0;
		long writeTotal = 0;
		for (int i = 0; i <= BlockNum; i++) {
			if (i < BlockNum) {
				writeSize = blockSize;
			} else {
				writeSize = FileSize - writeTotal;
			}
		}
		return true;
	}

	public  void splitDir(File dir, String type, int splitNum) {
		try {
			List<String> filesList = new ArrayList<String>();
			String[] files = listFiles(dir);
			for (String string : files) {
				String ext = getExtNoPoint(new File(string).getName());
				if (ext.equals(type)) {
					filesList.add(string);
				}
			}

			int j = splitNum;
			String filename = dir + "\\exmaytemp";
			String newName = filename;
			for (int i = 0; i < filesList.size(); i++) {
				File file = new File(filesList.get(i));
				copyFileToDirectory(new File(newName), file);
				file.delete();
				if (i % j == 0 && i != 0) {
					newName = filename + i / 200;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static File characterFileProcess(File file, String destPath) {
		// 创建一个输出流,用于写新的文件
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(destPath));
			// 创建一个输入流，用于读取文件
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				String newLine = replace(line);
				// 将替换后的内容写入新的文件中
				writer.write(newLine);
				line = reader.readLine();
			}
			reader.close();
			writer.close();
			return new File(destPath);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String replace(String line) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("，", ",");
		map.put("。", ".");
		map.put("〈", "<");
		map.put("〉", ">");
		map.put("‖", "|");
		map.put("《", "<");
		map.put("》", ">");
		map.put("〔", "[");
		map.put("〕", "]");
		map.put("﹖", "?");
		map.put("？", "?");
		map.put("“", "\"");
		map.put("”", "\"");
		map.put("：", ":");
		map.put("、", ",");
		map.put("（", "(");
		map.put("）", ")");
		map.put("【", "[");
		map.put("】", "]");
		map.put("—", "-");
		map.put("～", "~");
		map.put("！", "!");
		map.put("‵", "'");
		map.put("①", "1");
		map.put("②", "2");
		map.put("③", "3");
		map.put("④", "4");
		map.put("⑤", "5");
		map.put("⑥", "6");
		map.put("⑦", "7");
		map.put("⑧", "8");
		map.put("⑨", "9");

		int length = line.length();
		for (int i = 0; i < length; i++) {
			String charat = line.substring(i, i + 1);
			if (map.get(charat) != null) {
				line = line.replace(charat, (String) map.get(charat));
			}
		}
		return line;
	}

	public static void spiltToSmallFiles(File file, String outputFile)
			throws IOException {
		int fileCount = 0;
		// 定义单个文件的最大长度
		int MAX_SIZE = 10;
		// 创建文件输出流
		BufferedWriter writer = null;

		// 创建文件输入流
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		StringBuffer buffer = new StringBuffer();
		while (line != null) {
			buffer.append(line).append("\r\n");
			// 判断缓存区长度是否达到文件的最大长度
			if (buffer.toString().getBytes().length > MAX_SIZE) {
				writer = new BufferedWriter(new FileWriter(outputFile
						+ "output" + fileCount + ".txt"));
				writer.write(buffer.toString());
				writer.close();
				fileCount++;
				// 清空缓冲区数据
				buffer = new StringBuffer();
			}
			// 如果没有达到文件最大长度，则继续读取下一行
			line = reader.readLine();

		}
		// 如果太大的文件已经读取完毕，直接将缓冲区数据写入文件
		writer = new BufferedWriter(new FileWriter(outputFile + "output"
				+ fileCount + ".txt"));
		writer.write(buffer.toString());
		writer.close();
	}

	public static void preprocess(File file, String outputDir) {
		try {
			spiltToSmallFiles(file, outputDir);
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unchecked")
	public static void readJARList(String filename) throws IOException {
		JarFile jarFile = new JarFile(filename);
		Enumeration en = jarFile.entries();
		System.out.println("文件名\t文件大小\t压缩后的大小");
		while (en.hasMoreElements()) {
			process(en.nextElement());
		}
	}

	public static void process(Object obj) {
		JarEntry entry = (JarEntry) obj;
		String name = entry.getName();
		long size = entry.getSize();
		long compressedSize = entry.getCompressedSize();
		System.out.println(name + "\t" + size + "\t" + compressedSize);
	}

	public static void readJARFile(String jarFileName, String filename)
			throws IOException {
		JarFile jarFile = new JarFile(jarFileName);
		JarEntry entry = jarFile.getJarEntry(filename);
		InputStream inputStream = jarFile.getInputStream(entry);
		readFile(inputStream);
		jarFile.close();
	}

	public static void readFile(InputStream inputStream) throws IOException {
		InputStreamReader in = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(in);
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}

	public static void writeFileByBytes(String content, String filename)
			throws IOException {
		File file = new File(filename);
		OutputStream out = null;
		try {
			out = new FileOutputStream(file, true);
			byte[] bytes = content.getBytes();
			out.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
				}
			}
		}
	}

	/**
	 * 操作文件 以字节的方式进行文件写入
	 * 
	 * @param content
	 *            写入的内容
	 * @param filename
	 *            写入的文件
	 * @param encoding
	 *            写入的文件时的编码，可以为空
	 */
	public static void writeFileByChar(String content, String filename,
			String encoding) {
		File file = new File(filename);
		Writer writer = null;
		try {
			if (null == encoding || "".equals(encoding)) {
				writer = new OutputStreamWriter(new FileOutputStream(file));
			} else {
				writer = new OutputStreamWriter(new FileOutputStream(file),
						encoding);
			}
			writer.write(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 操作文件 以行为单位进行写入文件
	 * 
	 * @param content
	 *            写入文件的内容
	 * @param filename
	 *            文件
	 */
	public static void writeFileByLine(String content, String filename,
			boolean append) {
		File file = new File(filename);
		String pathname = new File(filename).getParent();
		if (!new File(pathname).exists()) {
			new File(pathname).mkdirs();
		}
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(file, append));
			writer.print(content);
			writer.println();
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static void writeContentByLine(String content, String filename,
			String encoding, boolean append) {
		File file = new File(filename);
		File pFile = new File(file.getParent());
		if (!pFile.exists()) {
			pFile.mkdirs();
		}
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new OutputStreamWriter(
					new FileOutputStream(file, append), encoding));
			writer.print(content);
			writer.println();
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 将内容一行行写入文件中
	 * 
	 * @param content
	 * @param filename
	 */
	public static void writeFileByLine(String content, String filename) {
		File file = new File(filename);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(file));
			writer.print(content);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 将内容写入文件中
	 * 
	 * @param content
	 * @param filename
	 */
	public static void writeFileByFileWriter(String content, String filename) {
		File file = new File(filename);
		Writer writer = null;
		try {
			writer = new FileWriter(file);
			writer.write(content);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 将内容写入文件中
	 * 
	 * @param content
	 * @param filename
	 */
	public static void writeFileByBufferFileWriter(String content,
			String filename) {
		File file = new File(filename);
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 将内容写入到文件中。
	 * 
	 * @param soruce
	 * @param destFile
	 * @param encoding
	 */
	public static void writerContent(String soruce, String destFile,
			String encoding) {
		try {
			FileOutputStream outputStream = new FileOutputStream(new File(
					destFile));
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
					outputStream, encoding);
			BufferedWriter writer = new BufferedWriter(outputStreamWriter);
			writer.write(soruce);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将内容追加到一个文件中.
	 * 
	 * @param soruce
	 * @param destFile
	 * @param encoding
	 * @param isAppend
	 */
	public static void writerContentToFile(String soruce, File destFile,
			String encoding, boolean isAppend) {
		try {
			FileOutputStream outputStream = new FileOutputStream(destFile,
					isAppend);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
					outputStream, encoding);
			BufferedWriter writer = new BufferedWriter(outputStreamWriter);
			writer.write(soruce);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writerContentToFile(String soruce, String destFile,
			String encoding, boolean isAppend) {
		writerContentToFile(soruce, new File(destFile), encoding, isAppend);
	}

	/**
	 * 操作文件之追加文件内容
	 * 
	 * @param content
	 *            追加的内容
	 * @param filename
	 *            追加的文件
	 * @param charsetName
	 *            编码 尽量使用utf-8
	 */
	public static void writerContentToFile(String content, String filename,
			String charsetName) {
		try {
			// "r", "rw", "rws", or "rwd"
			RandomAccessFile randomAccessFile = new RandomAccessFile(filename,
					"rw");
			long fileLength = randomAccessFile.length();// 获取文件字节数。
			randomAccessFile.seek(fileLength);// 将文件指针移动文件的尾部
			randomAccessFile.write(content.getBytes(charsetName));
			randomAccessFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 操作文件之追加文件内容
	 * 
	 * @param content
	 *            追加的内容
	 * @param filename
	 *            追加的文件
	 * @param flag
	 *            是否追加，false标识：覆盖之前的内容,true是追加
	 */
	public static void writerContentToFile(String content, String filename,
			boolean flag) {
		try {
			FileWriter writer = new FileWriter(filename, flag);
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将一个文件的内容复制给另一个文件
	 * 
	 * @param srcFile
	 * @param destFile
	 * @param encoding
	 * @param isAppend
	 */
	public static void writerFileLinesToFile(File srcFile, File destFile,
			String encoding, boolean isAppend) {
		try {
			FileInputStream inputStream = new FileInputStream(srcFile);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream, encoding));
			FileOutputStream outputStream = new FileOutputStream(destFile,
					isAppend);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
					outputStream, encoding);
			BufferedWriter writer = new BufferedWriter(outputStreamWriter);
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
			}
			writer.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writerFileLinesToFile(String srcFile, String destFile,
			String encoding, boolean isAppend) {
		writerFileLinesToFile(new File(srcFile), new File(destFile), encoding,
				isAppend);
	}

	
	
	public static String getUUIDFileName(String fileName){
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return getUUID()+extension;
	}
	
	public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    } 
	
	// 为上传文件自动分配文件名称，避免重复
	public static String getSmallFileName(String smallFileName,String fileName) {
		return "small_"+smallFileName;
	}
	
	// 为上传文件自动分配文件名称，避免重复
	public static String generateFileName(String fileName,int randomNum,int userId,String dataPattern) {
		// 获得当前时间
		DateFormat format = new SimpleDateFormat(dataPattern);
		// 转换为字符串
		String formatDate = format.format(new Date());
		// 随机生成文件编号
		int random = new Random().nextInt(randomNum);
		// 获得文件后缀名称
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		// 组成一个新的文件名称
		return formatDate + random+"_"+userId+ extension;
	}

	// 为上传文件自动分配文件名称，避免重复
	public static String generateDirName(String fileName) {
		// 获得当前时间
		DateFormat format = new SimpleDateFormat("HHmmss");
		// 转换为字符串
		String formatDate = format.format(new Date());
		// 随机生成文件编号
		int random = new Random().nextInt(10000);
		// 组成一个新的文件名(目录名)
		return "exmay_"+formatDate + random ;
	}


	public static String readFileByChars(String fileName, String encoding) {
		return readFileByChars(new File(fileName), encoding);
	}

	public static String readFileByChars(File fileName, String encoding) {
		StringBuffer buffer = new StringBuffer();
		Reader read = null;
		try {
			char[] tempchars = new char[30];
			int charread = 0;
			read = new InputStreamReader(new FileInputStream(fileName),
					encoding);
			while ((charread = read.read(tempchars)) != -1) {
				if ((charread == tempchars.length)
						&& (tempchars[tempchars.length - 1] != 'r')) {
					System.out.print(tempchars);
				} else {
					for (int i = 0; i < charread; i++) {
						if (tempchars[i] == 'r') {
							continue;
						} else {
							buffer.append(tempchars[i]);
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (read != null) {
				try {
					read.close();
				} catch (IOException e1) {
				}
			}
		}
		return buffer.toString();
	}

	public static String readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		StringBuffer buffer = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				buffer.append(tempString + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return buffer.toString();
	}

	public static List<String> readFileByLine(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		List<String> list = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				list.add(tempString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		Set<String> set = new HashSet<String>();
		List<String> newList = new ArrayList<String>();
		for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
			String element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		list.clear();
		list.addAll(newList);
		return list;
	}

	public static List<String> readFileByLine(String fileName, String encoding) {
		File file = new File(fileName);
		BufferedReader reader = null;
		List<String> list = new ArrayList<String>();
		try {
			FileInputStream inputStream = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(inputStream,
					encoding));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				list.add(tempString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		Set<String> set = new HashSet<String>();
		List<String> newList = new ArrayList<String>();
		for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
			String element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		list.clear();
		list.addAll(newList);
		return list;
	}

	@SuppressWarnings("unused")
	private static void showAvailableBytes(InputStream in) {// 显示输入流中还剩的字节数
		try {
			System.out.println("当前字节输入流中的字节数为:" + in.available());
		} catch (IOException e) {// 捕获异常
			e.printStackTrace();
		}
	}

	public static String readFile(File file, String encoding) {
		StringBuffer buffer = new StringBuffer();
		try {
			FileInputStream inputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, encoding);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				buffer.append(tempString + "\n");
			}
			reader.close();
		} catch (Exception e) {
		}
		return buffer.toString();
	}

	public static String readFile(String filename, String encoding) {
		return readFile(new File(filename), encoding);
	}

	public static String readFile(File file) {
		StringBuffer buffer = new StringBuffer();
		try {
			FileInputStream inputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				buffer.append(tempString + "\n");
			}
			reader.close();
		} catch (Exception e) {
		}
		return buffer.toString();
	}

	public static String readFile(String filename) {
		return readFile(new File(filename));
	}

	public static String readFiles(File[] files, String encoding) {
		StringBuffer buffer = new StringBuffer();
		for (File file : files) {
			buffer.append(readFile(file, encoding));
		}
		return buffer.toString();
	}

	public static String readFiles(String[] files, String encoding) {
		StringBuffer buffer = new StringBuffer();
		for (String pathname : files) {
			File file = new File(pathname);
			buffer.append(readFile(file, encoding));
		}
		return buffer.toString();
	}
	
	public static boolean isExist(String filePath){
		File file = new File(filePath);
		return file.exists();
	}
}