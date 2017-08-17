package com.sailing.service;

import com.sailing.dao.UserMapper;
import com.sailing.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
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
        User user1 = userService.selectByPrimaryKey("36331");
        System.out.println("u11111:"+user1.toString());
        User user2 = userMapper.selectByPrimaryKey("36331");
        System.out.println("u2:"+user2.toString());
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}