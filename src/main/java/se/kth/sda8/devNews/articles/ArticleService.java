package se.kth.sda8.devNews.articles;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private static Long idCounter = 1L;
    private static List<Article> articleList= new ArrayList<>();
    // ask Babe
    static {
        articleList.add(new Article(3L, "laundry", "kite", "richa"));
        articleList.add(new Article(5L, "kitchen", "cook today", "richa"));
    }
    public List<Article> getAll() {
        return articleList;
    }

    // Get articles by ID
    public Optional<Article> getByID(Long id) {
        return articleList.stream()
                .filter(article -> article.getId().equals(id))
                .findFirst();
    }
    // Create a new task as entered by the user
    public Article create(Article newArticle) {
        add(newArticle);
        return newArticle;
    }

    private static boolean add(Article newArticle) {
        //generate and set the id
        newArticle.setId(idCounter);
        idCounter++;
        return articleList.add(newArticle);
    }

    public void delete(Long id) {
        articleList = articleList.stream()
                                    .filter(t -> !t.getId().equals(id))
                                    .collect(Collectors.toList());
    }
}
