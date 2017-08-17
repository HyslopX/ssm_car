package com.sailing.entity;

public class CarChassisBrakeInfo {
    private String carId;

    private String driveMode;

    private String autoPowerType;

    private String frontSuspensionType;

    private String rearSuspensionType;

    private String frontBrakeType;

    private String rearBrakeType;

    private String parkingBrakeType;

    private String frontWheelSize;

    private String rearWheelSize;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getDriveMode() {
        return driveMode;
    }

    public void setDriveMode(String driveMode) {
        this.driveMode = driveMode;
    }

    public String getAutoPowerType() {
        return autoPowerType;
    }

    public void setAutoPowerType(String autoPowerType) {
        this.autoPowerType = autoPowerType;
    }

    public String getFrontSuspensionType() {
        return frontSuspensionType;
    }

    public void setFrontSuspensionType(String frontSuspensionType) {
        this.frontSuspensionType = frontSuspensionType;
    }

    public String getRearSuspensionType() {
        return rearSuspensionType;
    }

    public void setRearSuspensionType(String rearSuspensionType) {
        this.rearSuspensionType = rearSuspensionType;
    }

    public String getFrontBrakeType() {
        return frontBrakeType;
    }

    public void setFrontBrakeType(String frontBrakeType) {
        this.frontBrakeType = frontBrakeType;
    }

    public String getRearBrakeType() {
        return rearBrakeType;
    }

    public void setRearBrakeType(String rearBrakeType) {
        this.rearBrakeType = rearBrakeType;
    }

    public String getParkingBrakeType() {
        return parkingBrakeType;
    }

    public void setParkingBrakeType(String parkingBrakeType) {
        this.parkingBrakeType = parkingBrakeType;
    }

    public String getFrontWheelSize() {
        return frontWheelSize;
    }

    public void setFrontWheelSize(String frontWheelSize) {
        this.frontWheelSize = frontWheelSize;
    }

    public String getRearWheelSize() {
        return rearWheelSize;
    }

    @Override
    public String toString() {
        return "CarChassisBrakeInfo{" +
                "carId='" + carId + '\'' +
                ", driveMode='" + driveMode + '\'' +
                ", autoPowerType='" + autoPowerType + '\'' +
                ", frontSuspensionType='" + frontSuspensionType + '\'' +
                ", rearSuspensionType='" + rearSuspensionType + '\'' +
                ", frontBrakeType='" + frontBrakeType + '\'' +
                ", rearBrakeType='" + rearBrakeType + '\'' +
                ", parkingBrakeType='" + parkingBrakeType + '\'' +
                ", frontWheelSize='" + frontWheelSize + '\'' +
                ", rearWheelSize='" + rearWheelSize + '\'' +
                '}';
    }

    public void setRearWheelSize(String rearWheelSize) {
        this.rearWheelSize = rearWheelSize;
    }
}