package hollow.phantom.controller;

import com.fasterxml.jackson.annotation.JsonView;
import hollow.phantom.domain.Comment;
import hollow.phantom.domain.Message;
import hollow.phantom.domain.User;
import hollow.phantom.domain.Views;
import hollow.phantom.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    @JsonView(Views.FullComment.class)
    public Comment create(
            @RequestBody Comment comment,
            @AuthenticationPrincipal User user
    ) {
        return commentService.create(comment, user);
    }

    @PutMapping("{id}")
    @JsonView(Views.FullComment.class)
    public Comment update(
            @PathVariable("id") Comment commentFromDb,
            @RequestBody Comment comment,
            @AuthenticationPrincipal User user
    ) {
        return commentService.update(commentFromDb, comment, user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Comment comment,
                       @AuthenticationPrincipal User user
    ) {
        commentService.delete(comment, user);
    }
}
