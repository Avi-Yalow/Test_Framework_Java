package main.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @JsonProperty("userId")
    public int getUserId() {
        return this.userId;
    }

    public Post setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    int userId;

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public Post setId(int id) {
        this.id = id;
        return this;
    }

    int id;

    @JsonProperty("title")
    public String getTitle() {
        return this.title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    String title;

    @JsonProperty("body")
    public String getBody() {
        return this.body;
    }

    public Post setBody(String body) {
        this.body = body;
        return this;
    }

    String body;
}
