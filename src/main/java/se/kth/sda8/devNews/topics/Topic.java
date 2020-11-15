package se.kth.sda8.devNews.topics;

import se.kth.sda8.devNews.articles.Article;

import javax.persistence.*;
import java.util.List;

@Entity
@Table()
public class Topic {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "topics")
    private List<Article> article;

    public Topic() {
    }

 /*   public void setArticle(List<Article> articles){
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }*/

    public Topic(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
