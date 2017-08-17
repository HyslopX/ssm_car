package com.sailing.dao;

import com.sailing.entity.CarExternalInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface CarExternalInfoMapper {
    int deleteByPrimaryKey(String carId);

    int insert(CarExternalInfo record);

    int insertSelective(CarExternalInfo record);

    CarExternalInfo selectByPrimaryKey(String carId);

    int updateByPrimaryKeySelective(CarExternalInfo record);

    int updateByPrimaryKey(CarExternalInfo record);
}