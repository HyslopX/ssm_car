package com.sailing.web.controller;

import com.sailing.dao.*;
import com.sailing.entity.*;
import com.sailing.entity.Vo.HistoryVo;
import com.sailing.entity.Vo.PhoneOrderVo;
import com.sailing.entity.Vo.PicCarInfoVo;
import com.sailing.service.CarInfoService;
import com.sailing.service.PIcUrlImpl;
import com.sailing.service.UserService;
import org.apache.struts2.components.Else;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//页面切换控制
@Controller
@RequestMapping("/page")
public class PageController {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    FavMapper   fdavMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CarInfoService carInfoService;
    @Autowired
    CarEngineInfoMapper carEngineInfoMapper;
    @Autowired
    CarChassisBrakeInfoMapper carChassisBrakeInfoMapper;
    @Autowired
    UserService userService;
    @Autowired
    CarExternalInfoMapper carExternalInfoMapper;
    @Autowired
    CarInternalInfoMapper carInternalInfoMapper;
    @Autowired
    CarSafetyInfoMapper carSafetyInfoMapper;
    @Autowired
    HistoryMapper historyMapper;
    @Autowired
    PicMapper picMapper;
    @Autowired
    PIcUrlImpl pIcUrl;
//
//    @RequestMapping("/login")
//    public String showLogin(){
//        return "login";
//    }

    //进入首页
    @RequestMapping("/index")
    public String showIndex(HttpSession session)
    {
//        String id = "36331";
//        session.setAttribute("user",id);
        return "home1.1";
    }

    //index进入buy界面
    @RequestMapping("/showCar")
    public ModelAndView showCarInfo() throws Exception {
        //调用servie来查询商品列表
        List<CarInfo> itemsListTempt = carInfoService.selectCarInfoAll();
        List<CarInfo> itemsListAll = new ArrayList<CarInfo>();
        //筛选 可出售 汽车信息
        int i=0;
        for (CarInfo carInfo:itemsListTempt) {
            if(i>30) break;
            if(carInfo.getIslocked().equals("可出售")) {
                itemsListAll.add(carInfo);
            i++;
            }
        }
        //调用getPIcCarInfo方法 封装图片url和carInfo
        List<PicCarInfoVo> itemsList = pIcUrl.getPicCarInfo(itemsListAll);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        //指定逻辑视图名itemsList
        modelAndView.setViewName("car/buy0");

        return modelAndView;
    }

    //车型详细信息界面， buy-->details 根据id分别进入
    @RequestMapping("/details")
    public ModelAndView showDetails(HttpSession session,Integer id) throws Exception {
        //封装carInfo和pic_url
        CarInfo carInfoTempt = carInfoService.selectByPrimaryKey(String.valueOf(id));
        PicCarInfoVo carInfo = new PicCarInfoVo();
        carInfo.setCarInfo(carInfoTempt);
        String pic_url ="";
        List<Pic> pics = picMapper.selectByCarId(carInfoTempt.getCarId());
        if(pics!=null && pics.size()>0){
            pic_url = pics.get(0).getPicUrl();
        }
        carInfo.setPic_url(pic_url);
        CarEngineInfo carEngineInfo = carEngineInfoMapper.selectByPrimaryKey(String.valueOf(id));
        CarChassisBrakeInfo carChassisBrakeInfo=carChassisBrakeInfoMapper.selectByPrimaryKey(String.valueOf(id));
        CarSafetyInfo carSafetyInfo = carSafetyInfoMapper.selectByPrimaryKey(String.valueOf(id));
        CarExternalInfo carExternalInfo = carExternalInfoMapper.selectByPrimaryKey(String.valueOf(id));
        CarInternalInfo carInternalInfo = carInternalInfoMapper.selectByPrimaryKey(String.valueOf(id));
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("carInfo", carInfo);
        modelAndView.addObject("carEngineInfo", carEngineInfo);
        modelAndView.addObject("carChassisBrakeInfo",carChassisBrakeInfo);
        modelAndView.addObject("carSafetyInfo",carSafetyInfo);
        modelAndView.addObject("carExternalInfo",carExternalInfo);
        modelAndView.addObject("carInternalInfo",carInternalInfo);
        //指定逻辑视图名itemsList
        modelAndView.setViewName("car/details0");
        return modelAndView;
    }


    //进入用户中心
    @RequestMapping("/user")
    public ModelAndView showUserCenter(HttpSession session)
    {
//        System.out.println("sssss:"+session.getAttribute("u")); //测试 session传值
        String user_id=(String) session.getAttribute("user");
        User user=userMapper.selectByPrimaryKey(user_id);
        ModelAndView model= userService.showUserInfo(user);
        return model;
    }

    //买家查看自己拥有的订单 可取消订单
    @RequestMapping("/order")
    public ModelAndView showOrder(HttpSession session) {
        String user_id = (String) session.getAttribute("user");
//        System.out.println("user:"+user_id);
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orderList = orderMapper.selectByBid(user_id);
        List<PhoneOrderVo> itemsList = new ArrayList<PhoneOrderVo>();

        for (Order order:orderList) {
            String phone="";
            PhoneOrderVo temp = new PhoneOrderVo();
            User seller;
            seller = userMapper.selectByPrimaryKey(order.getSellerId());
            //用户数据不全 可能为空 引起空指针异常
            if(seller != null) phone = seller.getUphone();
            temp.setPhone(phone);
            temp.setOrder(order);
            itemsList.add(temp);
        }
//        System.out.println("XXX:"+itemsList);
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("user/unfinished_order");
        return modelAndView;
    }
    @RequestMapping("/collection")
    public ModelAndView collection(HttpSession session){
        String user_id = (String) session.getAttribute("user");
//        System.out.println("user:"+user_id);
        ModelAndView modelAndView = new ModelAndView();
        List<FavKey> favKeyList = fdavMapper.selectByUid(user_id);
        List<CarInfo> itemsList = new ArrayList<CarInfo>();

        //String phone;
        for (FavKey favKey:favKeyList) {
        //    PhoneOrderVo temp = new PhoneOrderVo();
            CarInfo carInfo;
            String car_id=favKey.getCarId();
            carInfo=carInfoService.selectByPrimaryKey(car_id);
            itemsList.add(carInfo);
        }
//        System.out.println("SSS:"+itemsList);
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("user/collection");
        return modelAndView;
    }

    //卖家查看自己被接收的订单 可确认订单
    @RequestMapping("/check_order")
    public ModelAndView checkOrder(HttpSession session) {
        String user_id = (String) session.getAttribute("user");
//        System.out.println("user:"+user_id);
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orderList = orderMapper.selectBySid(user_id);
        List<PhoneOrderVo> itemsList = new ArrayList<PhoneOrderVo>();


        for (Order order:orderList) {
            String phone="";
            PhoneOrderVo temp = new PhoneOrderVo();
            User seller;
            seller = userMapper.selectByPrimaryKey(order.getBuyerId());
            if(seller != null) phone = seller.getUphone();
            temp.setPhone(phone);
            temp.setOrder(order);
            itemsList.add(temp);
        }
        System.out.println("XXX2:"+itemsList);
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("user/check_order");
        return modelAndView;
    }
    //卖家查看自己已发布车型信息
    @RequestMapping("/check_car")
    public ModelAndView checkCar(HttpSession session){
        String user_id = (String) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        List<CarInfo> itemsListTempt = carInfoService.selectByUid(user_id);
        List<CarInfo> itemsList = new ArrayList<CarInfo>();
        for (CarInfo carInfo:itemsListTempt) {
            if(carInfo.getIslocked().equals("可出售")) itemsList.add(carInfo);
        }
        modelAndView.setViewName("user/check_car");
        modelAndView.addObject("itemsList",itemsList);
        return modelAndView;
    }
    //买家订单历史 管理员管理
    @RequestMapping("/bhistory")
    public ModelAndView showBuyHistory(HttpSession session) {
        String user_id = (String) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        List<History> histories = historyMapper.selectByBuyerId(user_id);
        List<HistoryVo> itemsList = new ArrayList<HistoryVo>();

        for (History history:histories) {
            CarInfo carInfo = carInfoService.selectByPrimaryKey(history.getCarId());
            User user = userMapper.selectByPrimaryKey(history.getSellerId());
            HistoryVo historyVo = new HistoryVo();
            historyVo.setCarInfo(carInfo);
            historyVo.setUser(user);
            itemsList.add(historyVo);
        }
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("user/buy_history");
        return modelAndView;
    }
    //卖家订单历史 管理员管理
    @RequestMapping("/shistory")
    public ModelAndView showSellHistory(HttpSession session) {
        String user_id = (String) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        List<History> histories = historyMapper.selectBySellerId(user_id);
        List<HistoryVo> itemsList = new ArrayList<HistoryVo>();

        for (History history:histories) {
            CarInfo carInfo = carInfoService.selectByPrimaryKey(history.getCarId());
            User user = userMapper.selectByPrimaryKey(history.getBuyerId());
            HistoryVo historyVo = new HistoryVo();
            historyVo.setCarInfo(carInfo);
            historyVo.setUser(user);
            itemsList.add(historyVo);
        }
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("user/sell_history");
        return modelAndView;

    }
}
