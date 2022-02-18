package academy.lgs.servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academy.lgs.domain.Article;
import academy.lgs.service.ArticleService;
import academy.lgs.service.impl.ArticleServiceImpl;


@WebServlet("/article")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArticleService articleService = ArticleServiceImpl.getArticleService();

	// to create resource (product)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");

		Article article = new Article(name, getValidatedPrice(price), description);
		articleService.create(article);
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	private double getValidatedPrice(String price) {
		if (price == null || price.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(price);
	}

	// to get resource (product)
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String articleId = request.getParameter("id");
		
		Article article = articleService.read(Integer.parseInt(articleId));
		
		request.setAttribute("article", article);
		request.getRequestDispatcher("singleArticle.jsp").forward(request, response);

	}

	// to update resource (product)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPut(req, resp);
	}

	// to delete resource (product)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doDelete(req, resp);
	}

}
