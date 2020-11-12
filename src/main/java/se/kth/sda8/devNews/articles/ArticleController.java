package se.kth.sda8.devNews.articles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/")
public class ArticleController {
    private static List<Article> articleList= new ArrayList<>();
    // ask Babe
    static {
        articleList.add(new Article(1L, "laundry", "kite", "richa"));
        articleList.add(new Article(2L, "kitchen", "cook today", "richa"));
    }
    //Get a list of all the articles
    @GetMapping("articles")
    public List<Article> getAll() {
        return articleList;
    }

    // Get articles by ID
    @GetMapping("articles/{id}")
    public Article getByID(@PathVariable Long id) {
        return articleList.stream()
                .filter(article -> article.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
