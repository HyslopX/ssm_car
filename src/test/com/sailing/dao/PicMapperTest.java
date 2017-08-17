package com.sailing.dao;

import com.sailing.entity.Pic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class PicMapperTest {
    @Autowired
    PicMapper picMapper;
    @Test
    public void selectByCarId() throws Exception {
        List<Pic> pics = picMapper.selectByCarId("10568");
        System.out.println("tt2t"+pics.toString());
        System.out.println("qq:"+pics.get(0).getPicUrl());
    }

}