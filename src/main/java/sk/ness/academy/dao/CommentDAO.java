package sk.ness.academy.dao;

import org.springframework.stereotype.Repository;
import sk.ness.academy.domain.Comment;

import java.util.List;

@Repository
public interface CommentDAO {

    Comment findByID(Integer commentId);

    List<Comment> findAll();

    void persist(Comment comment);

    void deleteComment(Integer commentId);
}
