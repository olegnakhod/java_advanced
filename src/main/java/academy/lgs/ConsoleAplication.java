package academy.lgs;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsoleAplication {
	private Cinema cinema = new Cinema();
	public Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ConsoleAplication ca = new ConsoleAplication();
		ca.realisationMenu();
	}

	public void realisationMenu() {

		while (true) {
			menu();
			int number = sc.nextInt();
			switch (number) {
			case 0: {
				System.exit(0);
			}
			case 1: {
				ConcoleMessage("назву фільму");
				String filmName = sc.next();
				ConcoleMessage("тривалість фільму,години");
				int hour = sc.nextInt();
				ConcoleMessage("тривалість фільму,хвилини");
				int minut = sc.nextInt();
				cinema.addMovie(filmName, hour, minut);
				break;
			}
			case 2: {
				ConcoleMessage("назву фільму");
				String filmName = sc.next();
				cinema.removeMovie(filmName);
				break;
			}
			case 3: {
				System.out.println(cinema.getMl().toString());
				break;
			}
			case 4: {
				System.out.println("Для додавання сеансу оберіть фільм із фільмотеки: ");
				System.out.println(cinema.getMl().toString());
				ConcoleMessage("день тиждня");
				String day = sc.next();
				ConcoleMessage("назву фільму");
				String filmName = sc.next();
				ConcoleMessage("початок фільму,години");
				int hour = sc.nextInt();
				ConcoleMessage("початок фільму,хвилини");
				int minut = sc.nextInt();
				cinema.addSeance(day, filmName, hour, minut);
				break;
			}
			case 5: {
				ConcoleMessage("день тиждня");
				String day = sc.next();
				ConcoleMessage("назву фільму");
				String filmName = sc.next();
				cinema.removeSeance(day, filmName);
				break;
			}
			case 6: {
				cinema.outAllSchedulesForWeek();
				break;
			}
			case 7: {
				ConcoleMessage("день тиждня");
				String day = sc.next();
				cinema.outAllMovieForDay(day);
				break;
			}
			}

		}

	}

	private void menu() {
		Links enter = (number, message) -> System.out.println("Натисніть " + number + " : щоб, " + message);
		enter.menuLink(0, "завершити роботу із додатком");
		enter.menuLink(1, "додати фільм у фільмотеку");
		enter.menuLink(2, "видалити фільм із фільмотеки");
		enter.menuLink(3, "відобразити всю фільмотеку");
		enter.menuLink(4, "додати сеанс фільму у розклад сеансів кінотеатру");
		enter.menuLink(5, "видалити фільм із розкладу сеансів кінотеатру");
		enter.menuLink(6, "відобразити розклад фільмів на весь тиждень");
		enter.menuLink(7, "відобразити розклад фільмів на конкретний день");
	}

	private static void ConcoleMessage(String message) {
		Consumer<String> print = x -> System.out.println("Введіть будь ласка " + x);
		print.accept(message);
	}

	interface Links {
		void menuLink(Integer number, String massage);
	}

}
