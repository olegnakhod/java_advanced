package academy.lgs.servelets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import academy.lgs.domain.Article;
import academy.lgs.service.ArticleService;
import academy.lgs.service.impl.ArticleServiceImpl;

@WebServlet("/articles")
public class ArticlesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArticleService articleService = ArticleServiceImpl.getArticleService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articleList = articleService.readAll();
		String json = new Gson().toJson(articleList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

}
