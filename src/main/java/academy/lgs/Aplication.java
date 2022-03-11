package academy.lgs;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Aplication {
	
	public static void main(String [] args) {
		
		Configuration config = new Configuration();
		config.configure("/META-INF/hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		Session session = config.buildSessionFactory(serviceRegistry).openSession();
		
		Post post = new Post();
		post.setTitle("War in Ukraine");
		
		Comment com1 = new Comment();
		com1.setAuthorName ("russia");
		com1.setText("We did`t attack at Ukraine");
		com1.setPost(post);
		
		Comment com2 = new Comment();
		com2.setAuthorName("Other world");
		com2.setText("We are very concerned");
		com2.setPost(post);
		
		Comment com3 = new Comment();
		com3.setAuthorName("Ukraine");
		com3.setText("russia we will kill you");
		com3.setPost(post);
		
		Set<Comment> comments = new HashSet();
		comments.add(com1);
		comments.add(com2);
		comments.add(com3);
		
		post.setComments(comments);
		
		Transaction transaction = session.beginTransaction();	
		session.save(post);
		transaction.commit();
		
	}
}
