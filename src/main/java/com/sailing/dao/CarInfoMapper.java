package com.sailing.dao;

import com.sailing.entity.CarInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarInfoMapper {
    int deleteByPrimaryKey(String carId);

    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    CarInfo selectByPrimaryKey(String carId);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);

    List<CarInfo> selectCarInfoAll();

    List<CarInfo> selectByUid(String uid);
}