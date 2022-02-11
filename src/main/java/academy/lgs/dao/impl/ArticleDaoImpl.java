package academy.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import academy.lgs.dao.ArticleDao;
import academy.lgs.domain.Article;
import academy.lgs.utils.ConnectionUtils;

public class ArticleDaoImpl implements ArticleDao {
	private static String READ_ALL = "select * from articles";
	private static String CREATE = "insert into articles(`name`, `price`, `description`) values (?,?,?)";
	private static String READ_BY_ID = "select * from articles where id =?";
	private static String UPDATE_BY_ID = "update articles set name = ?, price = ? , description = ? where id = ?";
	private static String DELETE_BY_ID = "delete from articles where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	private static Logger LOGGER = Logger.getLogger(ArticleDaoImpl.class);

	public ArticleDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			connection = ConnectionUtils.openConnection();
	}
	
	@Override
	public Article create(Article article) {

		try {
			preparedStatement = connection.prepareStatement(CREATE,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, article.getName());
			preparedStatement.setDouble(2, article.getPrice());
			preparedStatement.setString(3, article.getDescription());
			preparedStatement.executeUpdate();

			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			article.setArticleId(rs.getInt(1));
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return article;

	}
	

	
	@Override
	public Article read(Integer id) {
		Article article = null;

		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer articleId = result.getInt("id");
			String name = result.getString("name");
			Double price = result.getDouble("price");
			String description = result.getString("email");
			article = new Article(articleId, name, price, description);
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return article;
	}
	
	@Override
	public Article update(Article article) {

		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, article.getName());
			preparedStatement.setDouble(2, article.getPrice());
			preparedStatement.setString(3, article.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return article;
	}
	@Override
	public void delete(Integer id) {

		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			LOGGER.error(e);
		}
	}
	@Override
	public List<Article> readAll() {
		List<Article> listOfArticle = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer articleId = result.getInt("id");
				String name = result.getString("name");
				Double price = result.getDouble("price");
				String description = result.getString("email");
				listOfArticle.add(new Article(articleId, name, price, description));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return listOfArticle;
	}

}
