package hollow.phantom.service;

import hollow.phantom.domain.Comment;
import hollow.phantom.domain.Message;
import hollow.phantom.domain.User;
import hollow.phantom.domain.Views;
import hollow.phantom.dto.EventType;
import hollow.phantom.dto.ObjectType;
import hollow.phantom.repository.CommentRepository;
import hollow.phantom.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepository commentRepository, WsSender wsSender) {
        this.commentRepository = commentRepository;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepository.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }

    public void delete(Comment comment, User user) {
        if (comment.getAuthor().equals(user)) {
            commentRepository.delete(comment);
            wsSender.accept(EventType.REMOVE, comment);
        }
    }

    public Comment update(
            Comment commentFromDb,
            Comment comment,
            User user
    ) {
        if (commentFromDb.getAuthor().equals(user)) {
            commentFromDb.setText(comment.getText());
            Comment updatedComment = commentRepository.save(commentFromDb);

            wsSender.accept(EventType.UPDATE, updatedComment);

            return updatedComment;
        }
        return comment;
    }
}
