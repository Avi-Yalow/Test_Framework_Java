package com.moonactive.client;

import com.moonactive.models.Device;
import io.restassured.response.Response;

public class DeviceAPI extends BaseAPI<Device> {
    private static final String DEVICES_PATH = "/devices";

    private static DeviceAPI instance;
    public static DeviceAPI getInstance() {
        if (instance == null) {
            instance = new DeviceAPI();
        }
        return instance;
    }
    private DeviceAPI(){
        super();
    }
    public Response getAllDevices() { return get(DEVICES_PATH); }

    public Response getDeviceById(int id) {
        return get(DEVICES_PATH + "/" + id);
    }

    public Response createDevice(Device device) {
        return put(DEVICES_PATH, device);
    }



}
