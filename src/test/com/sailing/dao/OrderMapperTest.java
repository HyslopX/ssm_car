package com.sailing.dao;

import com.sailing.entity.CarInfo;
import com.sailing.entity.Order;
import com.sailing.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class OrderMapperTest {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    CarInfoMapper carInfoMapper;
    @Test
    public void selectByBid() throws Exception {
        List<Order> order = orderMapper.selectByBid("36331");
        System.out.println(order.size()+"-o1:"+order.toString());
    }

    @Test
    public void selectBySid() throws Exception {
        List<Order> list = orderMapper.selectBySid("12345");
        System.out.println(list.size()+"-o2："+list.toString());
    }
    @Test
    public void insert(){

        Random random = new Random();
        int result = random.nextInt(60000) % 30001 + 30000;
        String order_id = String.valueOf(result);
//        System.out.println("result:"+result);
//        CarInfo carInfo = CarInfoMapper.selectByPrimaryKey("36331");
//        User user = UserMapper.selectByPrimaryKey(user_id);
        //获取系统时间测试
        Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
//        System.out.println("ddd:"+dt);
//        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置显示格式
//        String nowTime="";
//        nowTime= df.format(dt);
//        System.out.println(nowTime);
        Order order = new Order(order_id,"10568","Tbas",22.2,2.0,"12345","AA","36331",dt,"未确认");
        orderMapper.insert(order);
    }
}