package com.sailing.entity;

public class CarInfo {
    private String carId;

    private String brand;

    private String carName;

    private String confName;

    private String level;

    private String engine;

    private String gearbox;

    private String bodyStructure;

    private String size;

    private String maximumspeed;

    private String cargoVolume;

    private Double carAge;

    private Double carMileage;

    private String carDamage;

    private String iseager;

    private Double price;

    private String licenseAddress;

    private String address;

    private String islocked;

    private String uid;

    public String getCarId() {
        return carId;
    }

    public CarInfo() {
    }

    public CarInfo(CarInfo carInfo) {
        this.carId = carInfo.getCarId();
        this.brand = carInfo.getBrand();
        this.carName = carInfo.getCarName();
        this.confName = carInfo.getConfName();
        this.level = carInfo.getLevel();
        this.engine = carInfo.getEngine();
        this.gearbox = carInfo.getGearbox();
        this.bodyStructure = carInfo.getBodyStructure();
        this.size = carInfo.getSize();
        this.maximumspeed = carInfo.getMaximumspeed();
        this.cargoVolume = carInfo.getCargoVolume();
        this.carAge = carInfo.getCarAge();
        this.carMileage = carInfo.getCarMileage();
        this.carDamage = carInfo.getCarDamage();
        this.iseager = carInfo.getIseager();
        this.price = carInfo.getPrice();
        this.licenseAddress = carInfo.getLicenseAddress();
        this.address = carInfo.getAddress();
        this.islocked = carInfo.getIslocked();
        this.uid = carInfo.getUid();
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getBodyStructure() {
        return bodyStructure;
    }

    public void setBodyStructure(String bodyStructure) {
        this.bodyStructure = bodyStructure;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaximumspeed() {
        return maximumspeed;
    }

    public void setMaximumspeed(String maximumspeed) {
        this.maximumspeed = maximumspeed;
    }

    public String getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(String cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public Double getCarAge() {
        return carAge;
    }

    public void setCarAge(Double carAge) {
        this.carAge = carAge;
    }

    public Double getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(Double carMileage) {
        this.carMileage = carMileage;
    }

    public String getCarDamage() {
        return carDamage;
    }

    public void setCarDamage(String carDamage) {
        this.carDamage = carDamage;
    }

    public String getIseager() {
        return iseager;
    }

    public void setIseager(String iseager) {
        this.iseager = iseager;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLicenseAddress() {
        return licenseAddress;
    }

    public void setLicenseAddress(String licenseAddress) {
        this.licenseAddress = licenseAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIslocked() {
        return islocked;
    }

    public void setIslocked(String islocked) {
        this.islocked = islocked;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "carId='" + carId + '\'' +
                ", brand='" + brand + '\'' +
                ", carName='" + carName + '\'' +
                ", confName='" + confName + '\'' +
                ", level='" + level + '\'' +
                ", engine='" + engine + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", bodyStructure='" + bodyStructure + '\'' +
                ", size='" + size + '\'' +
                ", maximumspeed='" + maximumspeed + '\'' +
                ", cargoVolume='" + cargoVolume + '\'' +
                ", carAge=" + carAge +
                ", carMileage=" + carMileage +
                ", carDamage='" + carDamage + '\'' +
                ", iseager='" + iseager + '\'' +
                ", price=" + price +
                ", licenseAddress='" + licenseAddress + '\'' +
                ", address='" + address + '\'' +
                ", islocked='" + islocked + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}