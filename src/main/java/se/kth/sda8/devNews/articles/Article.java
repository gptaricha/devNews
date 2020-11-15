package se.kth.sda8.devNews.articles;

import se.kth.sda8.devNews.comments.Comment;
import se.kth.sda8.devNews.topics.Topic;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Article")
public class Article {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name = "textBody")
    private String textBody;
    @Column(name = "authorName")
    private String authorName;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Comment> comments;

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Topic> topics;

    public Article() {
    }

    public Article(Long id, String title, String textBody, String authorName) {
        this.id = id;
        this.title = title;
        this.textBody = textBody;
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Comment> getComments() {
        return comments;
    }
/*
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }*/

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
