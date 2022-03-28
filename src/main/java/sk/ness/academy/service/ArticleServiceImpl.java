package sk.ness.academy.service;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import sk.ness.academy.dao.ArticleDAO;
import sk.ness.academy.domain.Article;
import sk.ness.academy.dto.ArticleInfo;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

  @Resource
  private ArticleDAO articleDAO;

  @Override
  public Article findByID(final Integer articleId) {
	  return this.articleDAO.findByID(articleId);
  }

  @Override
  public List<ArticleInfo> noComments() {
    return this.articleDAO.noComments();
  }

  @Override
  public List<ArticleInfo> searchArticles(String search) {
	  return this.articleDAO.searchArticles(search);
  }

  @Override
  public void createArticle(final Article article) {
	  this.articleDAO.persist(article);
  }

  @Override
  public void ingestArticles(final String jsonArticles) {

    ObjectMapper mapper = new ObjectMapper();

    try {
      //mapper.writeValueAsString(jsonArticles);
      List<Article> articles = List.of(mapper.readValue(jsonArticles, Article[].class));

      articles.forEach(a -> articleDAO.persist(a));

    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteArticle(final Integer articleId) {
    this.articleDAO.deleteArticle(articleId);
  }
}
