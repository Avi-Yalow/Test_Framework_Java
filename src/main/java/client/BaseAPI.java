package main.java.client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.config.Config;
import main.java.utils.Reporter;

public abstract class BaseAPI<T> {

    private final RequestSpecification requestSpec;
    protected Reporter reporter;

    public BaseAPI() {
        reporter = Reporter.getInstance();
        Config.ConfigLogOutput();
        this.requestSpec = RestAssured.given()
                .baseUri(Config.getInstance().getBaseUrl())
                .contentType(ContentType.JSON).log().all();
    }

    protected Response get(String path) {
        reporter.log("request is: " + requestSpec.toString());
        reporter.log("path is: " + path);
        return requestSpec.get(path);
    }

    protected Response post(String path, Object body) {
        reporter.log("request is: " + requestSpec.toString());
        reporter.log("path is: " + path);
        reporter.log("body is: " + body.toString());
        return requestSpec.body(body).post(path);
    }

    protected Response put(String path, Object body) {

        reporter.log("request is: " + requestSpec.toString());
        reporter.log("path is: " + path);
        reporter.log("body is: " + body.toString());
        return requestSpec.body(body).put(path);
    }

    protected Response delete(String path) {
        return requestSpec.delete(path);
    }

    protected RequestSpecification getBaseRequest() {
        return this.requestSpec;
    }

}
