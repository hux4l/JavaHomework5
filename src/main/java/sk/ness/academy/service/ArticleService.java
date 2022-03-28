package sk.ness.academy.service;

import java.util.List;

import sk.ness.academy.domain.Article;
import sk.ness.academy.dto.ArticleInfo;

public interface ArticleService {

    /**
     * Returns {@link Article} with provided ID
     */
    Article findByID(Integer articleId);

    /**
     * Returns all available {@link Article}s
     */
    List<Article> findAll();

    // no comments
    List<ArticleInfo> noComments();

    /**
     * Creates new {@link Article}
     */
    void createArticle(Article article);

    /**
     * Creates new {@link Article}s by ingesting all articles from json
     */
    void ingestArticles(String jsonArticles);

    // delete article
	void deleteArticle(Integer articleId);

}
