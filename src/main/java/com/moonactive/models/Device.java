package com.moonactive.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Device {

    int deviceId;
    String deviceType;
    Date updateDate;

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceType='" + deviceType + '\'' +
                ", updateDate=" + updateDate +
                ", turnedOn=" + turnedOn +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    boolean turnedOn;
    String location;
    String description;
    String companyCode;
    String model;

    @JsonProperty("deviceId")
    public int getDeviceId() {
        return this.deviceId; }
    public Device setDeviceId(int deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @JsonProperty("deviceType")
    public String getDeviceType() {
        return this.deviceType; }
    public Device setDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    @JsonProperty("updateDate")
    public Date getUpdateDate() {
        return this.updateDate; }
    public Device setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    @JsonProperty("turnedOn")
    public boolean getTurnedOn() {
        return this.turnedOn; }
    public Device setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
        return this;
    }

    @JsonProperty("location")
    public String getLocation() {
        return this.location; }
    public Device setLocation(String location) {
        this.location = location;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return this.description; }
    public Device setDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("companyCode")
    public String getCompanyCode() {
        return this.companyCode; }
    public Device setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
        return this;
    }

    @JsonProperty("model")
    public String getModel() {
        return this.model; }
    public Device setModel(String model) {
        this.model = model;
    return this;
    }

}
