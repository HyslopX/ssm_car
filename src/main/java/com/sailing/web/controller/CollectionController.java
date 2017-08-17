package com.sailing.web.controller;

import com.sailing.dao.FavMapper;
import com.sailing.entity.CarInfo;
import com.sailing.entity.FavKey;
import com.sailing.entity.Order;
import com.sailing.entity.User;
import com.sailing.entity.Vo.PhoneOrderVo;
import com.sailing.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
//收藏夹控制
@Controller
@RequestMapping("/collect")
public class CollectionController {
    @Autowired
    FavMapper favMapper;
    @Autowired
    CarInfoService  carInfoService;
    //details界面添加收藏夹
    @RequestMapping("/collect")
    @ResponseBody
    public String createCollection(HttpSession session, String cid) throws Exception
    {
        String user_id = (String) session.getAttribute("user");
        List<FavKey> favKeys =  favMapper.selectByUid(user_id);
        //若已有收藏 处理
        for (FavKey favKeyT:favKeys) {
            if(cid.equals(favKeyT.getCarId())) return "fail";
        }
        FavKey favKey = new FavKey(user_id,cid);
        favMapper.insert(favKey);
        return "success";
    }

    //买家取消选中的收藏夹
    @RequestMapping("/cancel")
    @ResponseBody
    public List<CarInfo> showCollection(HttpSession session, String id) {
        String user_id = (String) session.getAttribute("user");
//        System.out.println("user:"+user_id);
        //删除操作
        ModelAndView modelAndView = new ModelAndView();
        FavKey favKey = new FavKey(user_id,id);
//        System.out.println("fff1:"+favKey.toString());
        favMapper.deleteByPrimaryKey(favKey);
        List<FavKey> favKeyList = favMapper.selectByUid(user_id);
//        System.out.println("sss1:"+favKeyList);
        List<CarInfo> itemsList = new ArrayList<CarInfo>();
        for (FavKey favKey1:favKeyList) {
            CarInfo carInfo;
            String car_id=favKey1.getCarId();
            carInfo=carInfoService.selectByPrimaryKey(car_id);
            itemsList.add(carInfo);
            }
        return itemsList;
    }
}
