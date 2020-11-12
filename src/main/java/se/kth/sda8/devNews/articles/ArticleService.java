package se.kth.sda8.devNews.articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArticleService {
    private static List<Article> articleList= new ArrayList<>();
    // ask Babe
    static {
        articleList.add(new Article(1L, "laundry", "kite", "richa"));
        articleList.add(new Article(2L, "kitchen", "cook today", "richa"));
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
}
