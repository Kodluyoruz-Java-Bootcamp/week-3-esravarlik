package com.jojo.mediumproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User {
    private String userName;

    private String email;

    private String password;

    private List<Article> articles;

    private List<User> followedUsers;

    private List<Tag> followedTags;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
