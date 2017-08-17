package com.sailing.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/20.
 */
public interface SellCarService
{
    public void savePicture(MultipartFile file, HttpServletRequest request, int result) throws IOException, FileNotFoundException;
    public void saveBaseInfo(HttpServletRequest request, int result);
}
