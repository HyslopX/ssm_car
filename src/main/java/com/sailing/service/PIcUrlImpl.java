package com.sailing.service;


import com.sailing.dao.PicMapper;
import com.sailing.entity.CarInfo;
import com.sailing.entity.Pic;
import com.sailing.entity.Vo.PicCarInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PIcUrlImpl {
    @Autowired
    PicMapper picMapper;
    //输入CarInfo 得到包装类集合 含图片url和CarInfo
    public List<PicCarInfoVo> getPicCarInfo(List<CarInfo> carInfos){
        List<PicCarInfoVo> itemsList = new ArrayList<PicCarInfoVo>();
        for (CarInfo carInfo :carInfos) {
            PicCarInfoVo picCarInfoVo = new PicCarInfoVo();
            picCarInfoVo.setCarInfo(carInfo);
            String pic_url="";
            List<Pic> pics = picMapper.selectByCarId(carInfo.getCarId());
            if(pics!=null && pics.size()>0){
                pic_url = pics.get(0).getPicUrl();
            }
            picCarInfoVo.setPic_url(pic_url);
            itemsList.add(picCarInfoVo);
            System.out.println("ppp1:"+picCarInfoVo.toString());
        }
        return itemsList;
    }
}
