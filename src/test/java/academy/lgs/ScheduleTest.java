package academy.lgs;

import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;



public class ScheduleTest {
	private Schedule schedule;
	
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
		schedule = new Schedule();
		schedule.getSeances().add(new Seance(new Movie("Who",new Time(1,20)),new Time (12,00)));
		schedule.getSeances().add(new Seance(new Movie("PiratesOfTheCaribbean",new Time(1,20)),new Time (16,00)));
	}
	
	@After 
	public void afterTest(){
		schedule = null;
	}
	
	@Test
	public void Schedule_NO_NULL() {
		Set<Seance> expected = schedule.getSeances();
		Assert.assertNotNull(expected);
	}
	@Test
	public void addSeanceTest() {
		Set<Seance> expected = schedule.getSeances();
		MovieLibrary ml = new MovieLibrary();
		ml.getMoviesLibrary().add(new Movie("Who",new Time(1,20)));
		ml.getMoviesLibrary().add(new Movie("PiratesOfTheCaribbean",new Time(1,20)));
		Schedule scheduleTwo = new Schedule();
		scheduleTwo.addSeance("Who", 1, 20);
		scheduleTwo.addSeance("PiratesOfTheCaribbean", 1, 20);
		Set<Seance> actual = scheduleTwo.getSeances();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void removeSeanceTest() {
		schedule.removeSeance("PiratesOfTheCaribbean");
		Set<Seance> expected = schedule.getSeances();
		MovieLibrary ml = new MovieLibrary();
		ml.getMoviesLibrary().add(new Movie("Who",new Time(1,20)));
		Schedule scheduleTwo = new Schedule(); //create empty object
		scheduleTwo.addSeance("Who", 1, 20);
		Set<Seance> actual = scheduleTwo.getSeances();
		
		Assert.assertEquals(expected, actual);
	}
	
	
	
	

}
