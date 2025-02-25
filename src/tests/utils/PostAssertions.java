package tests.utils;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import main.java.models.Post;

import java.io.File;

import static main.java.utils.Constants.POST_SCHEMA;
import static org.hamcrest.Matchers.*;

public class PostAssertions {

    public static void assertPostCreated(Response response) {
        response.then()
                .log()
                .all()
                .statusCode(is(200));
    }

    public static void assertPostRetrieved(Response response, Post expectedPost) {
        response.then()
                .log()
                .all()
                .statusCode(is(200))
                .body("body", is(expectedPost.getBody()))
                .body("title", is(expectedPost.getTitle()));
    }

    public static void assertPostMatchesJsonSchema(Response response) {
        response.then()
                .log()
                .all()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(POST_SCHEMA)));
    }

    public static void assertGetAllPosts(Response response) {
        response.then()
                .log()
                .all()
                .statusCode(is(200));
    }

    public static void assertGetUnknownPost(Response response) {
        response.then()
                .log()
                .all()
                .statusCode(is(404))
                .body("error", is("Not Found"));
    }

}
