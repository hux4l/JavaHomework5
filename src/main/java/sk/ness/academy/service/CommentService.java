package sk.ness.academy.service;

import sk.ness.academy.domain.Article;
import sk.ness.academy.domain.Comment;

import java.util.List;

public interface CommentService {

    Comment findByID(Integer articleId);

    List<Comment> findAll();

    void createComment(Comment comment);

    void ingestComment(String jsonArticles);

    void deleteComment(Integer articleId);

}
