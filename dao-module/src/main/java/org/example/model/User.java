package org.example.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String hobbies;
    private String city;

    public User(int id, String username, String password, String sex, String hobbies, String city) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.hobbies = hobbies;
        this.city = city;
    }
    }
