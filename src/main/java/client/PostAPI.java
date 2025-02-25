package main.java.client;

import io.restassured.response.Response;
import main.java.models.Post;

public class PostAPI extends BaseAPI<Post> {
    private static final String POSTS_PATH = "/posts";

    private static PostAPI instance;

    public static PostAPI getInstance() {
        if (instance == null) {
            instance = new PostAPI();
        }
        return instance;
    }

    private PostAPI() {
        super();
    }

    public Response getAllPosts() {
        return get(POSTS_PATH);
    }

    public Response getPostById(int id) {
        return get(POSTS_PATH + "/" + id);
    }

    public Response createPost(Post newPost) {
        return post(POSTS_PATH, newPost);
    }

}
