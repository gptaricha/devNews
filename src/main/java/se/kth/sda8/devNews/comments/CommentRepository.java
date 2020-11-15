package se.kth.sda8.devNews.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Long> {
    //Select  comment from comments where article id is...
    List<Comment> findAllByArticleId(Long articleId);
}
