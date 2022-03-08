package academy.lgs.service;

import java.util.Map;

import academy.lgs.domain.Article;
import academy.lgs.shared.AbstractCRUD;

public interface ArticleService extends AbstractCRUD<Article> {
	public Map<Integer, Article> readAllMap();

}
