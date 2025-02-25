package tests.utils;

import main.java.models.Post;

public class PostDataGenerator {

    public static Post GetValidPost() {

        return new Post()
                .setUserId(1)
                .setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
                .setBody(
                        "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
    }

}
