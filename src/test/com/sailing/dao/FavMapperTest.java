package com.sailing.dao;

import com.sailing.entity.FavKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class FavMapperTest {
    @Autowired
    FavMapper favMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        FavKey favKey = new FavKey("12345","10568");
        favMapper.insert(favKey);
        System.out.println(favKey.toString());
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByUid() throws Exception {
        List<FavKey> favKey =  favMapper.selectByUid("36331");
        System.out.println("ttttt"+favKey.toString());
    }

    @Test
    public void selectByCarId() throws Exception {
    }

}