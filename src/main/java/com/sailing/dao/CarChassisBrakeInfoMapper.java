package com.sailing.dao;

import com.sailing.entity.CarChassisBrakeInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface CarChassisBrakeInfoMapper {
    int deleteByPrimaryKey(String carId);

    int insert(CarChassisBrakeInfo record);

    int insertSelective(CarChassisBrakeInfo record);

    CarChassisBrakeInfo selectByPrimaryKey(String carId);

    int updateByPrimaryKeySelective(CarChassisBrakeInfo record);

    int updateByPrimaryKey(CarChassisBrakeInfo record);
}