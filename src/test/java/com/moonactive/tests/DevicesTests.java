package com.moonactive.tests;

import com.moonactive.client.DeviceAPI;
import com.moonactive.models.Device;
import com.moonactive.utils.Reporter;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.moonactive.utils.DeviceDataGenerator.*;
import static com.moonactive.utils.DevicesAssertions.*;

public class DevicesTests {

    private DeviceAPI deviceAPI;
    private Device device;
    protected Reporter reporter;
    @BeforeClass
    public void setup(){
        reporter = Reporter.getInstance();
        deviceAPI = DeviceAPI.getInstance();
        device = new Device();
    }

    //Positive tests
    @Test
    public void testCreateDevice(){
        reporter.log("Testing create device");
        device = GetValidDevice();
        Response response = deviceAPI.createDevice(device);
        reporter.log("response is: " +response.asString());
        assertDeviceCreated(response);
    }

    @Test(dependsOnMethods = "testCreateDevice")
    public void testGetCreatedDevice(){
        Device expectedDevice = device;
        Response response = deviceAPI.getDeviceById(device.getDeviceId());
        assertDeviceRetrieved(response,expectedDevice);
    }

    @Test(dependsOnMethods = "testGetCreatedDevice")
    public void testDeviceMatchesJsonSchema(){
        Response response = deviceAPI.getDeviceById(device.getDeviceId());
        assertDeviceMatchesJsonSchema(response);
    }

    @Test()
    public void testGetAllDevices(){
        Response response =  deviceAPI.getAllDevices();
        assertGetAllDevices(response);
    }

    //Negative tests
    @Test
    public void testGetUnknownDevice(){
        Response response = deviceAPI.getDeviceById(-1);
        assertGetUnknownDevice(response);
    }
}
