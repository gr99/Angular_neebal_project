package com.example.volleyrecratetask;

public class UserModel {
    private int id;
    private String email;
    private String frist_name;
    private String last_name;
    private String avatar;

    public UserModel() {
    }

    ;

    public UserModel(int id, String email, String frist_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.frist_name = frist_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFrist_name(String frist_name) {
        this.frist_name = frist_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFrist_name() {
        return frist_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }


}
