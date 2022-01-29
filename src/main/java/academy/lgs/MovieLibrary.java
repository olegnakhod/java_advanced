package academy.lgs;

import java.util.Set;
import java.util.TreeSet;

public class MovieLibrary {
	private static Set<Movie> moviesLibrary = new TreeSet<>();
	
	public MovieLibrary() {
		moviesLibrary.add(new Movie("Predator", new Time(1, 30)));
		moviesLibrary.add(new Movie("Madagaskar", new Time(1,2)));
		moviesLibrary.add(new Movie("Terminator", new Time(1,2)));
	}

	public Set<Movie> getMoviesLibrary() {
		return moviesLibrary;
	}
	
	@Override
	public String toString() {
		return "Бібліотека фільмів: \n" + moviesLibrary;
	}

}
