package academy.lgs.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import academy.lgs.dao.ArticleDao;
import academy.lgs.dao.impl.ArticleDaoImpl;
import academy.lgs.domain.Article;
import academy.lgs.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private static ArticleService articleServiceImpl;
	private ArticleDao articleDao;
//	private static Logger LOGGER = Logger.getLogger(ArticleServiceImpl.class);
	
	private ArticleServiceImpl() {
			articleDao = new ArticleDaoImpl();
	}

	public static ArticleService getArticleService() {
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

	@Override
	public Map<Integer, Article> readAllMap() {
		return  readAll().stream().collect(Collectors.toMap(Article::getId, Function.identity()));
	}

}
