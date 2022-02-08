package academy.lgs.service.impl;

import java.util.List;

import academy.lgs.dao.ArticleDao;
import academy.lgs.dao.impl.ArticleDaoImpl;
import academy.lgs.domain.Article;
import academy.lgs.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;

	public ArticleServiceImpl() {
		articleDao = new ArticleDaoImpl();
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
