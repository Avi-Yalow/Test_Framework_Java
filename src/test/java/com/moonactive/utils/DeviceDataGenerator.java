package com.moonactive.utils;

import com.moonactive.models.Device;

import java.util.Date;

public class DeviceDataGenerator {

    public static Device GetValidDevice(){
        return new Device()
                .setDeviceId(1)
                .setDeviceType("dish washer")
                .setUpdateDate( new Date())
                .setTurnedOn(false)
                .setLocation("kitchen")
                .setDescription("start dish washer")
                .setCompanyCode("MG")
                .setModel("model0");
    }

}
