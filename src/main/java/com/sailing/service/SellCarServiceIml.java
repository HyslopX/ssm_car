package com.sailing.service;

import com.sailing.dao.*;
import com.sailing.entity.*;
import com.sailing.service.SellCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/7/20.
 */

@Service("sellCarService")
public class SellCarServiceIml implements SellCarService
{
    @Resource
    CarInfoMapper carInfoDao;
    @Resource
    CarChassisBrakeInfoMapper carChassisBrakeInfoMapper;
    @Resource
    CarEngineInfoMapper carEngineInfoMapper;
    @Resource
    CarExternalInfoMapper carExternalInfoMapper;
    @Resource
    CarInternalInfoMapper carInternalInfoMapper;
    @Resource
    CarSafetyInfoMapper carSafetyInfoMapper;
    @Resource
    PicMapper picMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public void savePicture(MultipartFile file, HttpServletRequest request,int result) throws IOException, FileNotFoundException {
        String ImagePath ="D:\\java_project\\src\\main\\webapp\\resources\\img\\car_pic";
        File targetfile = new File(ImagePath,result+file.getOriginalFilename());

        InputStream ins = file.getInputStream();
        FileOutputStream fos = new FileOutputStream(targetfile);

        byte b[] = new byte[1024];
        int temp = 0;

        while((temp = ins.read(b)) != -1){
            fos.write(b, 0, temp);
        }

        Random random = new Random();
        int result1 = random.nextInt(60000) % 26001 + 34000;
        Pic pic=new Pic();
        pic.setCarId(String.valueOf(result));
        pic.setPicUrl("/img/car_pic/"+targetfile.getName());
        pic.setPicId(String.valueOf(result1));
        picMapper.insert(pic);

        fos.close();
        ins.close();
    }

    @Override
    public void saveBaseInfo(HttpServletRequest request, int result) {
        CarInfo carInfo=new CarInfo();
        CarChassisBrakeInfo carChassisBrakeInfo=new CarChassisBrakeInfo();
        CarEngineInfo carEngineInfo=new CarEngineInfo();
        CarExternalInfo carExternalInfo=new CarExternalInfo();
        CarInternalInfo carInternalInfo=new CarInternalInfo();
        CarSafetyInfo carSafetyInfo=new CarSafetyInfo();

        carInfo.setCarId(String.valueOf(result));
        carInfo.setBrand(request.getParameter("brand"));
        carInfo.setCarName(request.getParameter("car_name"));
        carInfo.setCarAge(Double.parseDouble(request.getParameter("car_age")));
        carInfo.setCarMileage(Double.parseDouble(request.getParameter("car_mileage")));
        carInfo.setCarDamage(request.getParameter("car_damage"));
        carInfo.setIseager(request.getParameter("iseager"));
        carInfo.setPrice(Double.parseDouble(request.getParameter("price")));
        carInfo.setLicenseAddress(request.getParameter("license_address"));
        carInfo.setAddress(request.getParameter("address"));
        carInfo.setIslocked("待审核");
        String user_id = (String)request.getSession().getAttribute("user");
        User user = userMapper.selectByPrimaryKey(user_id);
        carInfo.setUid(user_id);
        carInfoDao.insert(carInfo);

        carChassisBrakeInfo.setCarId(String.valueOf(result));
        System.out.print("c2c:"+carChassisBrakeInfo.toString());
        carChassisBrakeInfoMapper.insert(carChassisBrakeInfo);

        carEngineInfo.setCarId(String.valueOf(result));
        carEngineInfoMapper.insert(carEngineInfo);

        carExternalInfo.setCarId(String.valueOf(result));
        carExternalInfoMapper.insert(carExternalInfo);

        carInternalInfo.setCarId(String.valueOf(result));
        carInternalInfoMapper.insert(carInternalInfo);

        carSafetyInfo.setCarId(String.valueOf(result));
        carSafetyInfoMapper.insert(carSafetyInfo);
    }


}
