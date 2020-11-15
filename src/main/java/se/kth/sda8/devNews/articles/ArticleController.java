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
    @GetMapping("/sort")
    public List<Article> getAllSorted(@RequestParam(required = false) String sortBy) {
        if(sortBy == null) {
            return articleService.getAll();
        } else {
            return articleService.getAllSorted(sortBy);
        }
    }
    @GetMapping("")
    public List<Article> getAll(@RequestParam(required = false) Long topicId) {
        System.out.println(topicId);
        if (topicId == null) {
            return articleService.getAll();
        } else {
            return articleService.getAllByTopicId(topicId);
        }
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
    @PutMapping("")
    public Article update(@RequestBody Article updatedArticle) {
        return articleService.update(updatedArticle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }

}
