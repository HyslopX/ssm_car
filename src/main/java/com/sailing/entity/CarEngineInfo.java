package com.sailing.entity;

public class CarEngineInfo {
    private String carId;

    private Double displacement;

    private String intakeForm;

    @Override
    public String toString() {
        return "CarEngineInfo{" +
                "carId='" + carId + '\'' +
                ", displacement=" + displacement +
                ", intakeForm='" + intakeForm + '\'' +
                ", cylinderArrangement='" + cylinderArrangement + '\'' +
                ", cylinders='" + cylinders + '\'' +
                ", maximumHorsepower='" + maximumHorsepower + '\'' +
                ", fuel='" + fuel + '\'' +
                ", fuelLabel='" + fuelLabel + '\'' +
                ", oilsupplyMode='" + oilsupplyMode + '\'' +
                ", enviromentStandard='" + enviromentStandard + '\'' +
                '}';
    }

    private String cylinderArrangement;

    private String cylinders;

    private String maximumHorsepower;

    private String fuel;

    private String fuelLabel;

    private String oilsupplyMode;

    private String enviromentStandard;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    public String getIntakeForm() {
        return intakeForm;
    }

    public void setIntakeForm(String intakeForm) {
        this.intakeForm = intakeForm;
    }

    public String getCylinderArrangement() {
        return cylinderArrangement;
    }

    public void setCylinderArrangement(String cylinderArrangement) {
        this.cylinderArrangement = cylinderArrangement;
    }

    public String getCylinders() {
        return cylinders;
    }

    public void setCylinders(String cylinders) {
        this.cylinders = cylinders;
    }

    public String getMaximumHorsepower() {
        return maximumHorsepower;
    }

    public void setMaximumHorsepower(String maximumHorsepower) {
        this.maximumHorsepower = maximumHorsepower;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getFuelLabel() {
        return fuelLabel;
    }

    public void setFuelLabel(String fuelLabel) {
        this.fuelLabel = fuelLabel;
    }

    public String getOilsupplyMode() {
        return oilsupplyMode;
    }

    public void setOilsupplyMode(String oilsupplyMode) {
        this.oilsupplyMode = oilsupplyMode;
    }

    public String getEnviromentStandard() {
        return enviromentStandard;
    }

    public void setEnviromentStandard(String enviromentStandard) {
        this.enviromentStandard = enviromentStandard;
    }
}