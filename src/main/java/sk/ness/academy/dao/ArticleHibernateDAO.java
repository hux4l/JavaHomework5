package sk.ness.academy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import sk.ness.academy.domain.Article;
import sk.ness.academy.dto.ArticleInfo;

@Repository
public class ArticleHibernateDAO implements ArticleDAO {

  @Resource(name = "sessionFactory")
  private SessionFactory sessionFactory;

  @Override
  public Article findByID(final Integer articleId) {
    Article result = sessionFactory.getCurrentSession().find(Article.class, articleId);
    Hibernate.initialize(result.getComments());
    return result;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Article> findAll() {
    List<Article> result = this.sessionFactory.getCurrentSession().createSQLQuery("select * from articles").addEntity(Article.class).list();
    List<Article> clone = new ArrayList<>(result);
    clone.forEach(article -> article.setComments(null));
    return clone;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<ArticleInfo> noComments() {
    Query<ArticleInfo> query = sessionFactory.getCurrentSession().createQuery("select new sk.ness.academy.dto.ArticleInfo(a.id, a.title, a.text, a.author, a.createTimestamp) from Article as a");
    return query.list();
  }

  @Override
  public void persist(final Article article) {
    this.sessionFactory.getCurrentSession().saveOrUpdate(article);
  }

  @Override
  public void deleteArticle(final Integer articleId) {
    this.sessionFactory.getCurrentSession().delete(findByID(articleId));
  }
}
