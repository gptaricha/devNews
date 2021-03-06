package se.kth.sda8.devNews.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("")
    public List<Comment> getAll(

            @RequestParam(required = false) Long articleId) {
        System.out.println(articleId);
        if(articleId == null) {
            return commentService.getAll();
        } else {
            return commentService.getAllByArticleId(articleId);
        }
    }
    @GetMapping("/{id}")
    public Comment getById(@PathVariable  Long id){
        return commentService.getById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Comment create(@RequestBody Comment newComment) {
        return commentService.create(newComment);
    }

    @PutMapping("")
    public Comment update(@RequestBody Comment updatedComment) {
        return commentService.update(updatedComment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
         commentService.delete(id);
    }

}
