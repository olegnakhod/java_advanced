package academy.lgs;

import java.util.TreeMap;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {
	
	Cinema cinema;
	Schedule schedule;
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED--> " + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED--> " + description.getMethodName());
		};
	};
	
	@Before
	public void beforeTest() {
		cinema = new Cinema();
		schedule = new Schedule();
		schedule.getSeances().add(new Seance(new Movie("Who",new Time(1,20)),new Time (12,00)));
		schedule.getSeances().add(new Seance(new Movie("PiratesOfTheCaribbean",new Time(1,20)),new Time (16,00)));
		cinema.getSchedules().put(Days.MONDAY,schedule);
		cinema.getSchedules().put(Days.SATURDAY,schedule);
	}
	
	@After
	public void afterTest() {
		cinema = null;
		schedule = null;
	}
	
	@Test 
	public void Cimena_NO_NULL() {
		TreeMap<Days, Schedule> expected = cinema.getSchedules();
		Assert.assertNotNull(expected);
	}
	
	@Test
	public void addSeanceInClassCinemaTest() {
		TreeMap<Days, Schedule> expected = cinema.getSchedules();
		MovieLibrary ml = new MovieLibrary();
		ml.getMoviesLibrary().add(new Movie("Who",new Time(1,20)));
		ml.getMoviesLibrary().add(new Movie("PiratesOfTheCaribbean",new Time(1,20)));
		Cinema cinemaTwo = new Cinema();
		cinemaTwo.addSeance("MONDAY", "Who", 12, 00);
		cinemaTwo.addSeance("MONDAY", "PiratesOfTheCaribbean", 16, 00);
		cinemaTwo.addSeance("SATURDAY", "Who", 12, 00);
		cinemaTwo.addSeance("SATURDAY", "PiratesOfTheCaribbean", 16, 00);
		TreeMap<Days, Schedule> actual = cinemaTwo.getSchedules();
		
		Assert.assertEquals(expected, actual);

	}
	
	@Test
	public void removeSeanceInClassCinemaTest() {
		cinema.removeSeance("MONDAY", "Who");
		TreeMap<Days, Schedule> expected = cinema.getSchedules();
		MovieLibrary ml = new MovieLibrary();
		ml.getMoviesLibrary().add(new Movie("Who",new Time(1,20)));
		ml.getMoviesLibrary().add(new Movie("PiratesOfTheCaribbean",new Time(1,20)));
		Cinema cinemaTwo = new Cinema();
//		cinemaTwo.addSeance("MONDAY", "Who", 12, 00); delete this movie
		cinemaTwo.addSeance("MONDAY", "PiratesOfTheCaribbean", 16, 00);
		cinemaTwo.addSeance("SATURDAY", "Who", 12, 00);
		cinemaTwo.addSeance("SATURDAY", "PiratesOfTheCaribbean", 16, 00);
		TreeMap<Days, Schedule> actual = cinemaTwo.getSchedules();
		
		Assert.assertEquals(expected, actual);	
	}
	
	@Test
	public void  removeMovieInClassCinemaTest() {
		cinema.removeMovie("Who");
		TreeMap<Days, Schedule> expected = cinema.getSchedules();
		MovieLibrary ml = new MovieLibrary();
		ml.getMoviesLibrary().add(new Movie("Who",new Time(1,20)));
		ml.getMoviesLibrary().add(new Movie("PiratesOfTheCaribbean",new Time(1,20)));
		Cinema cinemaTwo = new Cinema();
//		cinemaTwo.addSeance("MONDAY", "Who", 12, 00); //delete this movie
		cinemaTwo.addSeance("MONDAY", "PiratesOfTheCaribbean", 16, 00);
//		cinemaTwo.addSeance("SATURDAY", "Who", 12, 00);  //delete this movie
		cinemaTwo.addSeance("SATURDAY", "PiratesOfTheCaribbean", 16, 00);
		TreeMap<Days, Schedule> actual = cinemaTwo.getSchedules();
		
		Assert.assertEquals(expected, actual);	
	}

}
