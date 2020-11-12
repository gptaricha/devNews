package se.kth.sda8.devNews.articles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController

@RequestMapping("/")
public class ArticleController {
    private ArticleService articleService = new ArticleService();
    //Get a list of all the articles
    @GetMapping("articles")
    public List<Article> getAll() {
        return articleService.getAll();
    }

    // Get articles by ID
    @GetMapping("articles/{id}")
    public Article getByID(@PathVariable Long id) {
        return articleService.getByID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
