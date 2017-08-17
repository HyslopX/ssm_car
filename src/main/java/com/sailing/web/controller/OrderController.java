package com.sailing.web.controller;

import com.sailing.dao.FavMapper;
import com.sailing.dao.OrderMapper;
import com.sailing.dao.UserMapper;
import com.sailing.entity.CarInfo;
import com.sailing.entity.FavKey;
import com.sailing.entity.Order;
import com.sailing.entity.User;
import com.sailing.entity.Vo.PhoneOrderVo;
import com.sailing.service.CarInfoService;
import com.sailing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    CarInfoService carInfoService;
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    //deails页面点击预约 生成订单
    @RequestMapping("/create")
    @ResponseBody
    public String createOrder(HttpSession session, String id) throws Exception
    {
        String user_id = (String) session.getAttribute("user");
        //对已有订单处理
        List<Order> orders = orderMapper.selectByBid(user_id);
        for (Order order: orders) {
            if(order.getCarId().equals(id)) return "fail";
        }
        //添加新订单
        Random random = new Random();
        int result = random.nextInt(60000) % 30001 + 30000;
        String order_id = String.valueOf(result);
        CarInfo carInfo = carInfoService.selectByPrimaryKey(id);
        String seller_id = carInfo.getUid();
        //获取系统时间测试
        Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
//        System.out.println("ddd:"+dt);
//        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置显示格式
//        String nowTime="";
//        nowTime= df.format(dt);
//        System.out.println(nowTime);
        Order  order = new Order(order_id,id,carInfo.getConfName(),carInfo.getPrice(),carInfo.getPrice()*0.1,seller_id,carInfo.getAddress(),user_id,dt,"未确认");
        orderMapper.insert(order);
        return "success";
    }


    //查看订单页面 ，买家取消选中的订单
    @RequestMapping("/cancel")
    @ResponseBody
    public List<PhoneOrderVo> showOrder(HttpSession session,String id) {
        String user_id = (String) session.getAttribute("user");
//        System.out.println("user:"+user_id);
        ModelAndView modelAndView = new ModelAndView();
        //更新汽车状态为可出售
        Order orderTemp = orderMapper.selectByPrimaryKey(id);
        String car_id = orderTemp.getCarId();
        CarInfo carInfo = carInfoService.selectByPrimaryKey(car_id);
        carInfo.setIslocked("可出售");
        carInfoService.updateByPrimaryKey(carInfo);
        //删除操作
        orderMapper.deleteByPrimaryKey(id);

        List<PhoneOrderVo> itemsList = new ArrayList<PhoneOrderVo>();
        List<Order> orderList = orderMapper.selectByBid(user_id);

        for (Order order:orderList) {
            String phone="";
            PhoneOrderVo temp = new PhoneOrderVo();
            User seller;
            seller = userMapper.selectByPrimaryKey(order.getSellerId());
            if(seller!=null) phone = seller.getUphone();
            temp.setPhone(phone);
            temp.setOrder(order);
            itemsList.add(temp);
        }
        System.out.println("XXX:"+itemsList);
        return itemsList;
    }

    //confirmation
    //查看订单页面 ，卖家确认选中的订单
    @RequestMapping("/confirmation")
    @ResponseBody
    public List<PhoneOrderVo> confirmationOrder(HttpSession session,String id) {
        String user_id = (String) session.getAttribute("user");

        ModelAndView modelAndView = new ModelAndView();

        Order orderTemp = orderMapper.selectByPrimaryKey(id);
        //改变汽车状态为已被预订
        String car_id = orderTemp.getCarId();
        CarInfo carInfo = carInfoService.selectByPrimaryKey(car_id);
        carInfo.setIslocked("已被预订");
        carInfoService.updateByPrimaryKey(carInfo);

        //改变订单为已确认
        orderTemp.setOrderStatus("已确认");
        orderMapper.updateByPrimaryKey(orderTemp);

        List<PhoneOrderVo> itemsList = new ArrayList<PhoneOrderVo>();
        List<Order> orderList = orderMapper.selectBySid(user_id);

        for (Order order:orderList) {
            String phone="";
            PhoneOrderVo temp = new PhoneOrderVo();
            User buyer;
            buyer = userMapper.selectByPrimaryKey(order.getBuyerId());
            if(buyer != null) phone = buyer.getUphone();
            temp.setPhone(phone);
            temp.setOrder(order);
            itemsList.add(temp);
        }
        System.out.println("XXX2:"+itemsList);
        return itemsList;
    }

}
