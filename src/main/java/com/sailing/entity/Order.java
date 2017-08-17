package com.sailing.entity;

import java.util.Date;

public class Order {
    private String orderId;

    private String carId;

    private String baseinfo;

    private Double carPrice;

    private Double deposit;

    private String sellerId;

    private String address;

    private String buyerId;

    private Date orderTime;

    private String orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getBaseinfo() {
        return baseinfo;
    }

    public void setBaseinfo(String baseinfo) {
        this.baseinfo = baseinfo;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(String orderId, String carId, String baseinfo, Double carPrice, Double deposit, String sellerId, String address, String buyerId, Date orderTime, String orderStatus) {
        this.orderId = orderId;
        this.carId = carId;
        this.baseinfo = baseinfo;
        this.carPrice = carPrice;
        this.deposit = deposit;
        this.sellerId = sellerId;
        this.address = address;
        this.buyerId = buyerId;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", carId='" + carId + '\'' +
                ", baseinfo='" + baseinfo + '\'' +
                ", carPrice=" + carPrice +
                ", deposit=" + deposit +
                ", sellerId='" + sellerId + '\'' +
                ", address='" + address + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", orderTime=" + orderTime +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}