package se.kth.sda8.devNews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;
//    private static Long idCounter = 1L;
    //private static List<Article> articleList= new ArrayList<>();
    // ask Babe
    // curl -X PUT -d '{"id": 3, "title":"Agile2", "textBody":"how to learn Java","authorName":"Amanda"}' -H 'Content-Type: application/json' localhost:8080/articles/
    // curl -X POST -d '{"title":"JSP", "textBody":"how to learn JSP","authorName":"Magi"}' -H 'Content-Type: application/json' localhost:8080/articles/

   /* static {
        articleList.add(new Article(3L, "laundry", "kite", "richa"));
        articleList.add(new Article(5L, "kitchen", "cook today", "richa"));
    }*/
    public List<Article> getAllSorted(String sortby) {

        return repository.findAll().stream()
                .sorted(Comparator.comparing(sortby.equals("authorName") ? Article::getAuthorName : Article::getTitle))
                .collect(Collectors.toList());
    }
        public List<Article> getAll() {
        return repository.findAll();

    }
    // Get articles by ID
    public Optional<Article> getByID(Long id) {
        return repository.findById(id);
        /*return articleList.stream()
                .filter(article -> article.getId().equals(id))
                .findFirst();*/
    }
    // Create a new task as entered by the user
    public Article create(Article newArticle) {
    /*    newArticle.setId(idCounter);
        idCounter++;*/
        return repository.save(newArticle);
    }

    /*private static boolean add(Article newArticle) {
        //generate and set the id
        newArticle.setId(idCounter);
        idCounter++;
        return articleList.add(newArticle);
    }*/

    public void delete(Long id) {
        repository.deleteById(id);
        /*articleList = articleList.stream()
                                    .filter(t -> !t.getId().equals(id))
                                    .collect(Collectors.toList());*/
    }

    public Article update(Article updatedArticle) {
        return repository.save(updatedArticle);
    }

    public List<Article> getAllByTopicId(Long topicId) {
        return repository.findAllByTopicsId(topicId);
    }

}
