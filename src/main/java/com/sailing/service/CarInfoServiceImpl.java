package com.sailing.service;


import com.sailing.dao.CarInfoMapper;
import com.sailing.entity.CarInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarInfoServiceImpl implements CarInfoService{
    @Autowired
    private CarInfoMapper carInfoMapper;

    @Override
    public List<CarInfo> selectByUid(String uid) {
        return carInfoMapper.selectByUid(uid);
    }

    @Override
    public List<CarInfo> selectCarInfoAll() {
        return carInfoMapper.selectCarInfoAll();
    }

    @Override
    public int deleteByPrimaryKey(String carId) {
        return carInfoMapper.deleteByPrimaryKey(carId);
    }

    @Override
    public int insert(CarInfo record) {
        return carInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(CarInfo record) {
        return carInfoMapper.insertSelective(record);
    }

    @Override
    public CarInfo selectByPrimaryKey(String carId) {
        return carInfoMapper.selectByPrimaryKey(carId);
    }

    @Override
    public int updateByPrimaryKeySelective(CarInfo record) {
        return carInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CarInfo record) {
        return carInfoMapper.updateByPrimaryKey(record);
    }
}
