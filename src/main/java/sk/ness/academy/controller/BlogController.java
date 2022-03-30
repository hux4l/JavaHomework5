package sk.ness.academy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import sk.ness.academy.domain.Article;
import sk.ness.academy.domain.Comment;
import sk.ness.academy.dto.ArticleInfo;
import sk.ness.academy.dto.Author;
import sk.ness.academy.dto.AuthorStats;
import sk.ness.academy.exceptions.NotFoundException;
import sk.ness.academy.service.ArticleService;
import sk.ness.academy.service.AuthorService;
import sk.ness.academy.service.CommentService;

@RestController
public class BlogController {

    @Resource
    private ArticleService articleService;

    @Resource
    private AuthorService authorService;

    @Resource
    private CommentService commentService;

    // ~~ Article
    @RequestMapping(value = "articles", method = RequestMethod.GET)
    public List<ArticleInfo> getAllArticles() {
        return this.articleService.noComments();
    }

    @RequestMapping(value = "articles/{articleId}", method = RequestMethod.DELETE)
    public void deleteArticle(@PathVariable Integer articleId) {
        try {
            this.articleService.deleteArticle(articleId);
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article wih id " + articleId + " not found", e);
        }
    }

    @RequestMapping(value = "articles/{articleId}", method = RequestMethod.GET)
    public Article getArticle(@PathVariable final Integer articleId) {
        try {
            return this.articleService.findByID(articleId);
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article wih id " + articleId + " not found", e);
        }
    }

    @RequestMapping(value = "articles/search/{searchText}", method = RequestMethod.GET)
    public List<ArticleInfo> searchArticle(@PathVariable final String searchText) {
       return articleService.searchArticles(searchText);
    }

    @RequestMapping(value = "articles", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void addArticle(@RequestBody final Article article) {
        article.getComments().forEach(comment -> comment.setArticleId(article.getId()));
        this.articleService.createArticle(article);
    }

    // ~~ Author
    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public List<Author> getAllAuthors() {
        return this.authorService.findAll();
    }

    @RequestMapping(value = "authors/stats", method = RequestMethod.GET)
    public List<AuthorStats> authorStats() {
        return this.authorService.findAuthorStats();
    }

    // comment
    @RequestMapping(value = "comments", method = RequestMethod.GET)
    public List<Comment> getAllComments() {
        return this.commentService.findAll();
    }

    @RequestMapping(value = "comments/{commentId}", method = RequestMethod.GET)
    public Comment getComment(@PathVariable final Integer commentId) {
        Comment comment = this.commentService.findByID(commentId);
        if (comment == null) {
            throw new NotFoundException("Comment with id " + commentId + " not found");
        }
        return this.commentService.findByID(commentId);
    }

    @RequestMapping(value = "comments", method = RequestMethod.PUT)
    public void addArticle(@RequestBody Comment comment) {
        this.commentService.createComment(comment);
    }

    @RequestMapping(value = "comments/{commentId}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable Integer commentId) {
        try {
            this.commentService.deleteComment(commentId);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException("Comment with id " + commentId + " not found");
        }
    }
}
