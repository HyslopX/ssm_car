package com.sailing.service;

import com.sailing.entity.CarInfo;

import java.util.List;

public interface CarInfoService {
    int deleteByPrimaryKey(String carId);

    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    CarInfo selectByPrimaryKey(String carId);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);

    List<CarInfo> selectCarInfoAll();

    List<CarInfo> selectByUid(String uid);
}
