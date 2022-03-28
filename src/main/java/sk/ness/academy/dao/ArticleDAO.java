package sk.ness.academy.dao;

import java.util.List;

import sk.ness.academy.domain.Article;
import sk.ness.academy.dto.ArticleInfo;

public interface ArticleDAO {

    /**
     * Returns {@link Article} with provided ID
     */
    Article findByID(Integer articleId);

    /**
     * Returns all available {@link Article}s
     */
    List<Article> findAll();

    // find without comments
    List<ArticleInfo> noComments();

    /**
     * Persists {@link Article} into the DB
     */
    void persist(Article article);

    // delete article
    void deleteArticle(Integer articleId);
}
