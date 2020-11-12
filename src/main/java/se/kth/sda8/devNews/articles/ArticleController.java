package se.kth.sda8.devNews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    //Get a list of all the articles
    @GetMapping("")
    public List<Article> getAll() {
        return articleService.getAll();
    }

    // Get articles by ID
    @GetMapping("/{id}")
    public Article getByID(@PathVariable Long id) {
        return articleService.getByID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //Create an article , RequestBody helps to pass the body
    @PostMapping("")
    public Article create(@RequestBody Article newArticle) {
        return articleService.create(newArticle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }

}
