package com.sailing.entity.Vo;

import com.sailing.entity.CarInfo;
import com.sailing.entity.User;

public class HistoryVo {
    private User user;
    private CarInfo carInfo;

    @Override
    public String toString() {
        return "HistoryVo{" +
                "user=" + user +
                ", carInfo=" + carInfo +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(CarInfo carInfo) {
        this.carInfo = carInfo;
    }
}
