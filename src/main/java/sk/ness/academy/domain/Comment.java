package sk.ness.academy.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "comments")
@SequenceGenerator(name = "comments_seq_store", sequenceName = "comment_seq", allocationSize = 1)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq_store")
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "author")
    private String author;

    @Column(name = "text", length = 200)
    private String text;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "created_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Comment() {
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(final Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(final Integer articleId) {
        this.articleId = articleId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }
}
