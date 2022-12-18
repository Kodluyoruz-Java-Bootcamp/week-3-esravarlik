package com.jojo.mediumproject.model;

import lombok.Data;

import java.util.List;

@Data
public class Article {
    private String title;

    private String content;

    private List<Tag> tags;

    private Boolean isDraft = false;

    private User user;

    public Article(String title, String content, List<Tag> tags, Boolean isDraft) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.isDraft = isDraft;
    }
}
