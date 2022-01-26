package academy.lgs;

import java.util.Set;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;

import java.util.List;

public class Cinema {
	private TreeMap<Days, Schedule> schedules = new TreeMap<Days, Schedule>();
	private static final Time OPEN = new Time(9, 0);
	private static final Time CLOSE = new Time(23, 00);
	private MovieLibrary ml = new MovieLibrary();

	public Cinema() {
		schedules.put(Days.MONDAY, new Schedule());
		schedules.put(Days.TUESDAY, new Schedule());
		schedules.put(Days.WEDNESDAY, new Schedule());
		schedules.put(Days.THURSDAY, new Schedule());
		schedules.put(Days.FRIDAY, new Schedule());
		schedules.put(Days.SATURDAY, new Schedule());
		schedules.put(Days.SUNDAY, new Schedule());
	}

	public TreeMap<Days, Schedule> getSchedules() {
		return schedules;
	}

	public Time getOpen() {
		return OPEN;
	}

	public Time getClose() {
		return CLOSE;
	}

	public MovieLibrary getMl() {
		return ml;
	}

	@Override
	public String toString() {
		return "Кінотеатр 'Україна'. Розкалад сеансів: \n" + schedules + " \n Графік роботи кінотеатру: \n від: " + OPEN
				+ "\n до: " + CLOSE;
	}

	public void addMovie(String nameMovie, int hourDuration, int minDuration) {
		ml.getMoviesLibrary().add(new Movie(nameMovie, new Time(hourDuration, minDuration)));
	}

	public void addSeance(String day, String nameFilm, int hourStart, int minStart) {
		List<Movie> collect = ml.getMoviesLibrary().stream().filter(x -> nameFilm.equalsIgnoreCase(x.getTitle()))
				.collect(toList());
		int endSeansHour = hourStart + collect.get(0).getDuration().getHour();
		if ((hourStart + collect.get(0).getDuration().getHour()) > CLOSE.getHour()) {
			System.out.println("Фільм закінчується після закриття. Оберіть іншу годину початку");
		} else {
			endSeansHour = hourStart + collect.get(0).getDuration().getHour();
		}
		@SuppressWarnings("unused")
		int endSeansMinut;
		if ((minStart + collect.get(0).getDuration().getMin()) > 60) {
			endSeansMinut = (minStart + collect.get(0).getDuration().getMin()) - 60;
			endSeansHour++;
			if (endSeansHour > getClose().getHour()) {
				System.out.println("Фільм закінчується після закриття. Оберіть інші хвилини початку");
			}
		} else {
			endSeansMinut = minStart + collect.get(0).getDuration().getMin();
		}
		if (hourStart < getOpen().getHour()) {
			System.out.println("Ви ввели час початку сеансу який раніше ніж час відкриття кінотеатру ");
		}
		schedules.entrySet().stream().filter(x -> day.equalsIgnoreCase(x.getKey().toString()))
				.forEach(x -> x.getValue().addSeance(nameFilm, hourStart, minStart));
	}

	public void removeMovie(String nameMovie) {
		Set<Movie> collect = ml.getMoviesLibrary().stream().filter(x -> !nameMovie.equalsIgnoreCase(x.getTitle()))
				.collect(toSet());
		ml.getMoviesLibrary().clear();
		ml.getMoviesLibrary().addAll(collect);
		schedules.entrySet().stream().forEach(x -> x.getValue().removeSeance(nameMovie));
	}

	public void removeSeance(String day, String nameFilm) {
		schedules.entrySet().stream().filter(x -> day.equalsIgnoreCase(x.getKey().toString()))
				.forEach(x -> x.getValue().removeSeance(nameFilm));
	}

	public void outAllSchedulesForWeek() {
		System.out.println(this.toString());
	}

	public void outAllMovieForDay(String day) {
		schedules.entrySet().stream().filter(x -> day.equalsIgnoreCase(x.getKey().toString()))
				.forEach(x -> System.out.println(x.getValue().toString()));
	}

}
