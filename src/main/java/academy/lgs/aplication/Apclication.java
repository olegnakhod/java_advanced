package academy.lgs.aplication;


import java.util.Date;

import academy.lgs.domain.Article;
import academy.lgs.domain.Bucket;
import academy.lgs.domain.User;
import academy.lgs.service.ArticleService;
import academy.lgs.service.BucketService;
import academy.lgs.service.UserService;
import academy.lgs.service.impl.ArticleServiceImpl;
import academy.lgs.service.impl.BucketServiceImpl;
import academy.lgs.service.impl.UserServiceImpl;

public class Apclication {
	

	public static void main(String[] args) {
		Date date = new Date();
		UserService user = new UserServiceImpl();
		ArticleService article = new ArticleServiceImpl();
		BucketService bucket = new BucketServiceImpl();
		user.create(new User("test","test","test@test", "test", "test"));
		article.create(new Article("test",2.2,"test"));
		bucket.create(new Bucket(1,1,date ));
	}
}
