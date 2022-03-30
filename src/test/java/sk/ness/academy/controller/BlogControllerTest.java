package sk.ness.academy.controller;

import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sk.ness.academy.domain.Article;
import sk.ness.academy.domain.Comment;

import javax.xml.crypto.Data;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BlogControllerTest {

    Article article;
    Comment comment1;
    Comment comment2;

    Date date;

    @BeforeEach
    void setUp() {

        date = new Date();

        article = new Article();
        article.setId(1);
        article.setAuthor("Tomas");
        article.setText("What the hell you are talking about");
        article.setTitle("Talking");

        comment1 = new Comment();
        comment1.setCommentId(1);
        comment1.setAuthor("Me");
        comment1.setText("What you are talking about?");
        comment1.setDate(date);

    }

    @Test
    void getAllArticles() {
    }

    @Test
    void deleteArticle() {
    }

    @Test
    void getArticle() {
    }

    @Test
    void searchArticle() {
    }

    @Test
    void addArticle() {
    }

    @Test
    void getAllAuthors() {
    }

    @Test
    void authorStats() {
    }

    @Test
    void getAllComments() {
    }

    @Test
    void getComment() {
    }

    @Test
    void testAddArticle() {
    }

    @Test
    void deleteComment() {
    }
}