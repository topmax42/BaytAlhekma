package com.example.baytalhekma.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    static User instance;



    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("avatar")
    @Expose
    private Object avatar;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("college")
    @Expose
    private String college;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("isPremium")
    @Expose
    private Boolean isPremium;
    private Integer college_id = 1;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public String getMobile() {
        return mobile;
    }

    public Integer getCollege_id() {
        return college_id;
    }

    public Integer getId() {
        return id;
    }

    public void setCollege_id(Integer college_id) {
        this.college_id = college_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User(String name, String email, String mobile, int id) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.id = id;
    }
    public static synchronized User getInstance() {
        if (instance == null) {
            instance = new User("","","", 1);
            }
        return instance;
    }
    public static synchronized void setInstace(User user) {
       instance = user;

    }
}
