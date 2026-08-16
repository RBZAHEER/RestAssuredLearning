package org.api.pojo;

public class PostResponse {
    private int userId;
    private int id;
    private String title;
    private String body;

    //Note-->The empty constructor is important because Jackson needs to be able to create the object and then populate its fields.
    public PostResponse(){}

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
