package se.kth.sda8.devNews.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.kth.sda8.devNews.comments.Comment;

import java.util.List;

// Persistence layer
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAllByTopicsId(Long topicId);
}
