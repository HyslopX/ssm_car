package com.sailing.dao;

import com.sailing.entity.CarInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class CarInfoMapperTest {
    @Autowired
    CarInfoMapper carInfoMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        CarInfo carInfo = carInfoMapper.selectByPrimaryKey("10568");
        System.out.println("sss:"+carInfo.getGearbox());
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void selectCarInfoAll() throws Exception {
    }

    @Test
    public void selectByUid() throws Exception {
        List<CarInfo> itemsList = carInfoMapper.selectByUid("40803");
        System.out.println("321123:"+itemsList);
    }

}