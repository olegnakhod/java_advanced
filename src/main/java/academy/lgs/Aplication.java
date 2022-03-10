package academy.lgs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Aplication {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(ssrb.build());

		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();

		Card card = new Card("hardware components", "my PC");
		
		Set<Item> items = new HashSet<Item>();
		
		Item item1 = new Item ("processor");
		Item item2 = new Item ("motherboard");
		Item item3 = new Item ("RAM");
		Item item4 = new Item("ROM");
		
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		
		card.setItems(items);
			
		session.persist(card);

		transaction.commit();
		session.close();
		
	}

}
