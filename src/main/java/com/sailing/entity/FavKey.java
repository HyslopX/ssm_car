package com.sailing.entity;

public class FavKey {
    private String uid;

    private String carId;

    @Override
    public String toString() {
        return "FavKey{" +
                "uid='" + uid + '\'' +
                ", carId='" + carId + '\'' +
                '}';
    }

    public FavKey() {
    }

    public FavKey(String uid, String carId) {
        this.uid = uid;
        this.carId = carId;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
}