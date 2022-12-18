package com.jojo.mediumproject.controller;

import com.jojo.mediumproject.model.Article;
import com.jojo.mediumproject.model.User;
import com.jojo.mediumproject.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getAllArticle() {
        return articleService.getAllArticle();
    }

    @GetMapping("/users")
    public List<Article> getAllByArticle(@RequestBody User user) {
        return articleService.getAllByArticle(user);
    }

    @PostMapping
    public void createArticle(@RequestBody Article article) {
        articleService.createArticle(article);

    }

    @DeleteMapping
    public void deleteArticle(@RequestBody Article article) {
        this.articleService.deleteArticle(article);

    }


}
