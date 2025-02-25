package test.post_tests;

import io.restassured.response.Response;
import main.java.client.PostAPI;
import main.java.models.Post;
import main.java.utils.Reporter;

import static test.utils.PostAssertions.*;
import static test.utils.PostDataGenerator.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostTests {

    private PostAPI postAPI;
    private Post postPOJO;
    protected Reporter reporter;

    @BeforeClass
    public void setup() {
        reporter = Reporter.getInstance();
        postAPI = PostAPI.getInstance();
        postPOJO = new Post();
    }

    // Positive tests
    @Test
    public void testCreatePost() {
        reporter.log("Testing create post");
        postPOJO = GetValidPost();
        Response response = postAPI.createPost(postPOJO);
        reporter.log("response is: " + response.asString());
        assertPostCreated(response);
    }

    @Test(dependsOnMethods = "testCreatePost")
    public void testGetCreatedPost() {
        Post expectedPost = postPOJO;
        Response response = postAPI.createPost(postPOJO);
        int id = response.jsonPath().getInt("id");
        response = postAPI.getPostById(id);
        assertPostRetrieved(response, expectedPost);
    }

    @Test(dependsOnMethods = "testGetCreatedPost")
    public void testPostMatchesJsonSchema() {
        Response response = postAPI.createPost(postPOJO);
        int id = response.jsonPath().getInt("id");
        response = postAPI.getPostById(id);
        assertPostMatchesJsonSchema(response);
    }

    @Test
    public void testGetAllPosts() {
        Response response = postAPI.getAllPosts();
        assertGetAllPosts(response);
    }

    // Negative tests
    @Test
    public void testGetUnknownDevice() {
        Response response = postAPI.getPostById(-1);
        assertGetUnknownPost(response);
    }
}
