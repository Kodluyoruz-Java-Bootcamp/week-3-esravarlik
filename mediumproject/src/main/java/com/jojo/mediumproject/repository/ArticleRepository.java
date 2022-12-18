package com.jojo.mediumproject.repository;

import com.jojo.mediumproject.model.Article;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleRepository {
    private static final List<Article> articleList = new ArrayList<>();

    public void createArticle(Article article) {
        articleList.add(article);
    }

    public void deleteArticle(Article article) {
        articleList.remove(article);
    }

    public List<Article> findAllArticle() {
        return articleList;
    }
}
