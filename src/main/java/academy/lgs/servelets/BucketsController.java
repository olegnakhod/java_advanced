package academy.lgs.servelets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import academy.lgs.domain.Bucket;
import academy.lgs.dto.BucketDto;
import academy.lgs.domain.Article;
import academy.lgs.service.ArticleService;
import academy.lgs.service.BucketService;
import academy.lgs.service.impl.ArticleServiceImpl;
import academy.lgs.service.impl.BucketServiceImpl;

@WebServlet("/buckets")
public class BucketsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private	BucketService bucketService = BucketServiceImpl.getBucketService();
	private ArticleService articleService = ArticleServiceImpl.getArticleService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bucket> buckets = bucketService.readAll();
		Map<Integer, Article> idToArticle = articleService.readAllMap();
		List<BucketDto> listOfBucketDtos = map(buckets, idToArticle);
		
		String json = new Gson().toJson(listOfBucketDtos);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	
	public List<BucketDto> map(List<Bucket> buckets, Map<Integer, Article> idToProduct){

		return	buckets.stream().map(bucket->{
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucketId = bucket.getId();
			bucketDto.purchaseDate = bucket.getDate();
		   
			Article article = idToProduct.get(bucket.getArticle().getId());
		    bucketDto.name = article.getName();
		    bucketDto.description = article.getDescription();
		    bucketDto.price = article.getPrice();
			
			return bucketDto;
		}).collect(Collectors.toList());
		
	} 

}
