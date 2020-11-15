package se.kth.sda8.devNews.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository repository;

    public List<Topic> getAll() {
        return repository.findAll();
    }

    public Optional<Topic> getById(Long id) {
        return repository.findById(id);
    }

    public Topic create(Topic newTopic) {
        return repository.save(newTopic);
    }

    public Topic update(Topic updatedTopic){
        return repository.save(updatedTopic);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Topic> getAllByArticleId(Long articleId) {
        return repository.findByArticleId(articleId);
    }
}
