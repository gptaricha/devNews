package se.kth.sda8.devNews.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("")
    public List<Topic> getAll(@RequestParam(required = false) Long articleId) {
        if (articleId != null) {
            return topicService.getAllByArticleId(articleId);
        }
        else {
            return topicService.getAll();
        }
    }

    @GetMapping("/{id}")
    public Topic getByID(@PathVariable Long id) {
        return topicService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Topic create(@RequestBody Topic newTopic) {
        return topicService.create(newTopic);
    }

    @PutMapping("")
    public Topic update(@RequestBody Topic updatedTopic) {
        return topicService.update(updatedTopic);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        topicService.delete(id);
    }

    
}
