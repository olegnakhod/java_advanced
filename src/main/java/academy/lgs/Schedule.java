package academy.lgs;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import static java.util.stream.Collectors.*;

public class Schedule{
	private Set<Seance> seances = new TreeSet<>();
	private MovieLibrary ml = new MovieLibrary() ;

	public Set<Seance> getSeances() {
		return seances;
	}

	@Override
	public int hashCode() {
		return Objects.hash(seances);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return Objects.equals(seances, other.seances);
	}

	@Override
	public String toString() {
		return "Розкалад: \n" + seances;
	}

	public  void addSeance(String nameFilm, int hourStart, int minStart) {
		Movie movie = ml.getMoviesLibrary().stream().filter(x->nameFilm.equalsIgnoreCase(x.getTitle())).findFirst().get();
		seances.add(new Seance(movie, new Time(hourStart,minStart)));
	}

	public Set<Seance> removeSeance(String nameFilm) {
		Set<Seance> collect = seances.stream().filter(x -> !nameFilm.equals(x.getMovie().getTitle())).collect(toSet());
		this.seances.clear();
		this.seances.addAll(collect);
		return this.seances;
	}
}
