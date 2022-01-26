package academy.lgs;

import java.util.Objects;

public class Time {
	private int min;
	private int hour;

	public Time(int hour, int min) {
		setMin(min);
		setHour(hour);
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		if (min >= 0 && min <= 60) {
			this.min = min;
		} else {
			System.err.println("Ввведіть значення у межах від 0 до 60");
		}
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour >= 0 && hour <= 24) {
			this.hour = hour;
		} else {
			System.err.println("Ввведіть значення у межах від 0 до 24");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(hour, min);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hour == other.hour && min == other.min;
	}

	@Override
	public String toString() {
		return hour + ":" + min;
	}

}
