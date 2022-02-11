package academy.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import academy.lgs.dao.ArticleDao;
import academy.lgs.dao.impl.ArticleDaoImpl;
import academy.lgs.domain.Article;
import academy.lgs.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private static ArticleService articleServiceImpl;
	private ArticleDao articleDao;
	private static Logger LOGGER = Logger.getLogger(ArticleServiceImpl.class);
	
	private ArticleServiceImpl() {
		try {
			articleDao = new ArticleDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static ArticleService getProductService() {
		if (articleServiceImpl == null) {
			articleServiceImpl = new ArticleServiceImpl();
		}

		return articleServiceImpl;
	}

	@Override
	public Article create(Article t) {
		return articleDao.create(t);
	}

	@Override
	public Article read(Integer id) {
		return articleDao.read(id);
	}

	@Override
	public Article update(Article t) {
		return articleDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		articleDao.delete(id);

	}

	@Override
	public List<Article> readAll() {
		return articleDao.readAll();
	}

}
