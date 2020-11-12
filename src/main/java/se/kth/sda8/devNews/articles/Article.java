package se.kth.sda8.devNews.articles;

public class Article {
    private Long id;
    private String title;
    private String textBody;
    private String authorName;

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
}
