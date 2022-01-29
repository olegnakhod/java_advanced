package academy.lgs;

import java.util.Objects;

public class Seance implements Comparable<Seance>{
	private Movie movie;
	private Time startTime;
	private Time endTime;

	public Seance(Movie movie, Time startTime) {
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = calculeteEndTime(movie.getDuration(), startTime);
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(endTime, movie, startTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		return Objects.equals(endTime, other.endTime) && Objects.equals(movie, other.movie)
				&& Objects.equals(startTime, other.startTime);
	}
	
	@Override
	public String toString() {
		return "Сеанс " + movie + " \n Початок сеансу о: " + startTime + "\n Кінець сеансу о: " + endTime + "\n";
	}

	private Time calculeteEndTime(Time duration, Time startTime) {
		Time endTime = new Time(0, 0);
		int hour = duration.getHour() + startTime.getHour();
		if (hour > 24) {
			endTime.setHour(hour - 24);
		} else {
			endTime.setHour(hour);
		}

		int min = duration.getMin() + startTime.getMin();
		if (min > 60) {
			endTime.setMin(min - 60);
			if (min - 60 != 0) {
				endTime.setHour(endTime.getHour() + 1);
			}
		} else {
			endTime.setMin(min);
		}
		return endTime;
	}


	@Override
	public int compareTo(Seance s) {
		int result = this.getMovie().getTitle().compareTo(s.getMovie().getTitle());
		return result;
	}
}
