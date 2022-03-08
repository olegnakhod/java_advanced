package academy.lgs.servelets;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import academy.lgs.domain.Article;
import academy.lgs.domain.Bucket;
import academy.lgs.domain.User;
import academy.lgs.service.ArticleService;
import academy.lgs.service.BucketService;
import academy.lgs.service.UserService;
import academy.lgs.service.impl.ArticleServiceImpl;
import academy.lgs.service.impl.BucketServiceImpl;
import academy.lgs.service.impl.UserServiceImpl;


@WebServlet("/bucket")
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BucketService bucketService = BucketServiceImpl.getBucketService();
	private ArticleService articleService = ArticleServiceImpl.getArticleService();
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String articleId = request.getParameter("articleId");
		
		Article article = articleService.read(Integer.parseInt(articleId));

		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		User user = userService.read(userId);

		Bucket bucket = new Bucket();
		bucket.setId(UUID.randomUUID().toString());
		bucket.setArticle(article);
		bucket.setUser(user);
		bucket.setDate(new Date());
		
		bucketService.create(bucket);

		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bucketId = request.getParameter("bucketId");
		bucketService.delete(Integer.parseInt(bucketId));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
