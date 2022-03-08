package academy.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import academy.lgs.dao.ArticleDao;
import academy.lgs.domain.Article;
import academy.lgs.shared.FactoryManager;

public class ArticleDaoImpl implements ArticleDao {
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Article create(Article article) {
		try {
			em.getTransaction().begin();
			em.persist(article);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return article;
	}

	@Override
	public Article read(Integer id) {
		Article article = null;
		try {
			article = em.find(Article.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return article;
	}

	@Override
	public Article update(Article t) {
		return null;
	}

	@Override
	public void delete(Integer id) {
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Article e");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
}
