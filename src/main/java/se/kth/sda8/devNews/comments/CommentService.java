package se.kth.sda8.devNews.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repository;

    public List<Comment> getAll() {
        return repository.findAll();
    }

    public Optional<Comment> getById(Long id){
        return repository.findById(id);
    }

    public Comment create(Comment newComment) {
        return repository.save(newComment);
    }

    public Comment update(Comment updatedComment) {
        return repository.save(updatedComment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Comment> getAllByArticleId(Long articleId) {
        return repository.findAllByArticleId(articleId);
    }
}
