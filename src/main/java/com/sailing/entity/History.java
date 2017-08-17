package com.sailing.entity;



public class History {
    private String historyId;

    private String buyerId;

    private String carId;

    private String sellerId;

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getSellerId() {
        return sellerId;
    }

    @Override
    public String toString() {
        return "History{" +
                "historyId='" + historyId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", carId='" + carId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                '}';
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
}