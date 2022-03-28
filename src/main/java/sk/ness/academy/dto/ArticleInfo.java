package sk.ness.academy.dto;

import java.util.Date;

public class ArticleInfo {

    private Integer id;

    private String title;

    private String text;

    private String author;

    private Date timeStamp;

    public ArticleInfo(final Integer id, final String title, final String text, final String author, final Date timeStamp) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author = author;
        this.timeStamp = timeStamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(final Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
