package com.sailing.dao;

import com.sailing.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        User user = userMapper.selectByPrimaryKey("36331");
        System.out.println("uu1:"+user.toString());
        user.setUid("12345");
        user.setUsername("AA");
        user.setUemail("3434343434@qq.com");
        userMapper.insert(user);
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void selectByUname(){
        User user = userMapper.selectByUsername("AA");
        System.out.println("CCC:"+user.toString());
    }
    @Test
    public void selectByEmail(){
        User user = userMapper.selectByUemail("3434343434@qq.com");
        System.out.println("AAA"+user.toString());
    }
}