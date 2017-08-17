package com.sailing.dao;

import com.sailing.entity.CarInternalInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInternalInfoMapper {
    int deleteByPrimaryKey(String carId);

    int insert(CarInternalInfo record);

    int insertSelective(CarInternalInfo record);

    CarInternalInfo selectByPrimaryKey(String carId);

    int updateByPrimaryKeySelective(CarInternalInfo record);

    int updateByPrimaryKey(CarInternalInfo record);
}