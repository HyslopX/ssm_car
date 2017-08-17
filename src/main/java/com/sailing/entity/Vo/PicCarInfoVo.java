package com.sailing.entity.Vo;


import com.sailing.entity.CarInfo;

public class PicCarInfoVo {
    String pic_url;
    CarInfo carInfo;

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    @Override
    public String toString() {
        return "PicCarInfoVo{" +
                "pic_url='" + pic_url + '\'' +
                ", carInfo=" + carInfo +
                '}';
    }

    public void setCarInfo(CarInfo carInfo) {
        this.carInfo = carInfo;
    }
}
