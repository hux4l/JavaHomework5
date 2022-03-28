package sk.ness.academy.service;

import org.springframework.stereotype.Service;
import sk.ness.academy.dao.CommentDAO;
import sk.ness.academy.domain.Article;
import sk.ness.academy.domain.Comment;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    @Resource
    private CommentDAO commentDAO;

    @Override
    public Comment findByID(final Integer commentId) {
        return this.commentDAO.findByID(commentId);
    }

    @Override
    public List<Comment> findAll() {
        return commentDAO.findAll();
    }

    @Override
    public void createComment(Comment comment) {
        this.commentDAO.persist(comment);
    }

    @Override
    public void ingestComment(final String jsonArticles) {
        throw new UnsupportedOperationException("Comment ingresting not supported");
    }

    @Override
    public void deleteComment(final Integer commentId) {
        this.commentDAO.deleteComment(commentId);
    }
}
