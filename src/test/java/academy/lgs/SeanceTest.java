package academy.lgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class SeanceTest {
	private Seance seance;
	
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
		seance = new Seance (new Movie("Who",new Time(1,20)),new Time (12,00));
	}
	
	@After
	public void afterTest() {
		seance = null;
	}
	
	@Test  
	public void calculeteEndTimeTest() {
		Time expected = seance.getEndTime();
		Time actual = new Time(13,20);
		
		Assert.assertEquals(expected, actual);
	}
}

