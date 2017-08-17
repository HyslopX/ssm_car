package com.sailing.web.controller;

import com.sailing.entity.CarInfo;
import com.sailing.entity.Vo.PicCarInfoVo;
import com.sailing.service.CarInfoService;
import com.sailing.service.PIcUrlImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("carInfo")
public class CarInfoController {
    @Autowired
    CarInfoService carInfoService;
    @Autowired
    PIcUrlImpl pIcUrl;
    //buy页面点击确定 筛选车基本信息 返回信息至buy
//    @RequestMapping("/selectCar")
//    public ModelAndView selectCar() {
//        List<CarInfo> itemsListAll = carInfoService.selectCarInfoAll();
//        List<CarInfo> itemsList = new ArrayList<>();
//        for (CarInfo item : itemsListAll) {
//            if (item.getCarName().equals("迈特威")) {
//                itemsList.add(item);
//            }
//        }
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("itemsList", itemsList);
//        //指定逻辑视图名itemsList
//        modelAndView.setViewName("buyTest");
//
//        return modelAndView;
//    }

//    //测试(done)：buyTest 选择信息 筛选车型信息
//    @RequestMapping("/selectCar1")
//    @ResponseBody
//    public List<CarInfo> selectCar1(String carbrand,String carname){
//
//        List<CarInfo> itemsListAll = carInfoService.selectCarInfoAll();
//        List<CarInfo> itemsList = new ArrayList<>();
//        System.out.println("12111111"+carbrand+"  "+carname);
//        for (CarInfo item:itemsListAll) {
////            System.out.println("3333"+item.getCarName());
//            if(item.getCarName().equals(carname) && carname!="不限" &&item.getBrand().equals(carbrand)){
//                System.out.println("2121"+item.toString());
//                itemsList.add(item);
//            }
//        }
//        System.out.println("3333"+itemsList.toString());
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.addObject("itemsList", itemsList);
////        //指定逻辑视图名itemsList
////        modelAndView.setViewName("buyTest");
//
//        return itemsList;
//    }

    //测试：buyTest 选择信息 筛选车型信息
//    @RequestMapping("/selectCar1")
//    public ModelAndView selectCar1(String carbrand,String carname){
//
//        List<CarInfo> itemsListAll = carInfoService.selectCarInfoAll();
//        List<CarInfo> itemsList = new ArrayList<>();
////        System.out.println("12111111"+carbrand+"  "+carname);
//        for (CarInfo item:itemsListAll) {
////            System.out.println("3333"+item.getCarName());
//            if(item.getCarName().equals(carname) && carname!="不限" &&item.getBrand().equals(carbrand)){
////                System.out.println("2121"+item.toString());
//                itemsList.add(item);
//            }
//        }
//        System.out.println("3333"+itemsList.toString());
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("itemsList", itemsList);
////        //指定逻辑视图名itemsList
//        modelAndView.setViewName("buyTest2");
//
//        return modelAndView;
//    }
    //buy页面 筛选汽车信息
    @RequestMapping("/selectCar")
    @ResponseBody
    public List<PicCarInfoVo> selectCar(CarInfo carInfo, Double price1, Double price2, Double age1, Double age2,String gearbox) {
        List<CarInfo> itemsListAll = carInfoService.selectCarInfoAll();
//        List<PicCarInfoVo> itemsList = new ArrayList<PicCarInfoVo>();
        List<CarInfo> itemsListCar = new ArrayList<CarInfo>();
        List<CarInfo> itemsListTempt = new ArrayList<CarInfo>();
        itemsListTempt.addAll(itemsListAll);
        //选择可出售汽车
        itemsListCar.clear();
        for (CarInfo item : itemsListTempt) {
            if (item.getIslocked().equals("可出售")) {
                itemsListCar.add(item);
            }
        }
        itemsListTempt.clear();
        itemsListTempt.addAll(itemsListCar);
        //筛选carName
        itemsListCar.clear();
        if (carInfo.getCarName().equals("0")) {
            itemsListCar.addAll(itemsListTempt);
        } else {
            for (CarInfo item : itemsListTempt) {
                if (item.getCarName().equals(carInfo.getCarName())) {
                    itemsListCar.add(item);
                }
            }
        }
        itemsListTempt.clear();
        itemsListTempt.addAll(itemsListCar);
        //筛选brand
        itemsListCar.clear();
        System.out.println(itemsListTempt);
        if (carInfo.getBrand().equals("0") ) {
            itemsListCar.addAll(itemsListTempt);
        } else {
            for (CarInfo item : itemsListTempt) {
                if (item.getBrand().equals(carInfo.getBrand())) {
                    itemsListCar.add(item);
                }
            }
        }
        itemsListTempt.clear();
        itemsListTempt.addAll(itemsListCar);
        //筛选level
        itemsListCar.clear();
        if (carInfo.getLevel().equals("0")) {
            itemsListCar.addAll(itemsListTempt);
        } else {
            for (CarInfo item : itemsListTempt) {
                if (item.getLevel().equals(carInfo.getLevel())) {
                    itemsListCar.add(item);
                }
            }
        }
        itemsListTempt.clear();
        itemsListTempt.addAll(itemsListCar);
        //筛选gearbox
        itemsListCar.clear();
        if (gearbox==null || gearbox.equals("0")) {
            itemsListCar.addAll(itemsListTempt);
        }  else {
            for (CarInfo item : itemsListTempt) {
                //档字写错了我的妈耶 挡档挡
                if (item.getGearbox().equals(gearbox)) {
                    itemsListCar.add(item);
                }
            }
        }
        itemsListTempt.clear();
        itemsListTempt.addAll(itemsListCar);
        //筛选price
        itemsListCar.clear();
        for (CarInfo item : itemsListTempt) {
            if (item.getPrice() <= price2 && item.getPrice() >= price1) {
                itemsListCar.add(item);
            }
        }
        itemsListTempt.clear();
        itemsListTempt.addAll(itemsListCar);
        //筛选carAge
        itemsListCar.clear();
        for (CarInfo item : itemsListTempt) {
            if (item.getCarAge() <= age2 && item.getCarAge() >= age1) {
                itemsListCar.add(item);
            }
        }
        itemsListTempt.clear();
        itemsListTempt.addAll(itemsListCar);
        List<PicCarInfoVo> itemsList = pIcUrl.getPicCarInfo(itemsListCar);

        return itemsList;
    }


}
