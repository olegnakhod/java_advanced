package academy.lgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Aplication {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		CoustomersDao coustomersDao = new CoustomersDao(ConnectionUtils.openConnection());
		MagazinesDao magazinesDao = new MagazinesDao(ConnectionUtils.openConnection());

		List<Coustomers> listOfCoustomers = new ArrayList<>();
		listOfCoustomers.add(new Coustomers("Kolja", "Tokar"));
		listOfCoustomers.add(new Coustomers("Igor", "Fedko"));
		listOfCoustomers.add(new Coustomers("Vasja", "Fedosjuk"));
		listOfCoustomers.add(new Coustomers("Olga", "Denisova"));
		listOfCoustomers.add(new Coustomers("Inga", "Kotova"));

		List<Magazines> listOfMagazines = new ArrayList();
		listOfMagazines.add(new Magazines("АвтоСвіт", 12));
		listOfMagazines.add(new Magazines("Пізнайко", 10));
		listOfMagazines.add(new Magazines("Сад і город", 20));
		listOfMagazines.add(new Magazines("Maxim", 40));

//		listOfCoustomers.forEach(coustomer -> {
//			try {
//				coustomersDao.insert(coustomer);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});

//		listOfMagazines.forEach(magazine -> {
//			try {
//				magazinesDao.insert(magazine);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});

		// READ-ALL
		coustomersDao.readAll().forEach(System.out::println);
		magazinesDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		// READ-ById
		Coustomers coustomerFromBD = coustomersDao.read(2);
		Magazines magazinesFromBD = magazinesDao.read(4);
		System.out.println(coustomerFromBD);
		System.out.println(magazinesFromBD);
//
//		// UPDATE - ById
		coustomerFromBD.setLastName(coustomerFromBD.getLastName() + "-Borisov");
		magazinesFromBD.setName(magazinesFromBD.getName() + " i Galja");
		coustomersDao.update(coustomerFromBD);
		magazinesDao.update(magazinesFromBD);

		// READ-ALL
		coustomersDao.readAll().forEach(System.out::println);
		magazinesDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		coustomersDao.delete(6);
		magazinesDao.delete(6);

		// READ-ALL
		coustomersDao.readAll().forEach(System.out::println);
		magazinesDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

	}

}
