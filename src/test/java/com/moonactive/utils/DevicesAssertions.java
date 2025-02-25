package com.moonactive.utils;

import com.moonactive.models.Device;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;

import static com.moonactive.utils.Constants.DEVICE_SCHEMA;
import static org.hamcrest.Matchers.*;

public class DevicesAssertions {

    public static void assertDeviceCreated(Response response) {
        response.then()
                .log()
                .all()
                .statusCode(is(200));
    }

    public static void assertDeviceRetrieved(Response response, Device expectedDevice) {
        response.then()
                .log()
                .all()
                .statusCode(is(200))
                .body("deviceId",is(expectedDevice.getDeviceId()))
                .body("deviceType", is(expectedDevice.getDeviceType()));
    }
    public static void assertDeviceMatchesJsonSchema(Response response) {
        response.then()
                .log()
                .all()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(DEVICE_SCHEMA)));
    }

    public static void assertGetAllDevices(Response response) {
        response.then()
                .log()
                .all()
                .statusCode(is(200));
    }

    public static  void assertGetUnknownDevice(Response response) {
        response.then()
                .log()
                .all()
                .statusCode(is(404))
                .body("error",is("Not Found"));
    }

}
