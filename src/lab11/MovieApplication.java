package lab11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MovieApplication {

	private static Scanner scnr;
	private static Map<Integer, String> menu = new HashMap<>();

	public static void main(String[] args) {
		scnr = new Scanner(System.in);

		System.out.println("Welcome to the Movie List Application!");
		System.out.println();
		System.out.println("There are 10 movies in the list of genres below.");
		fillMovieMenu();
		printMenu();
		whileLoop();

	}

	private static void fillMovieMenu() {
		menu.put(1, "animated");
		menu.put(2, "comedy");
		menu.put(3, "horror");
		menu.put(4, "scifi");
		menu.put(5, "drama");
		menu.put(6, "musical");
	}

	private static void printMenu() {
		System.out.printf("%-20s %-20s\n", "Genre Number", "Genre");
		System.out.println("==========================");
		for (Map.Entry<Integer, String> entry : menu.entrySet()) {
			System.out.printf("%-20d %-20s\n", entry.getKey(), entry.getValue());
		}
	}

	private static void whileLoop() {
		boolean movieTime = true;
		while (movieTime) {
			System.out.println();
			System.out.print("What genre are you interested in? ");
			try {
				int genreNumber = scnr.nextInt();
				scnr.nextLine();
				if (menu.containsKey(genreNumber)) {
					String genreName = menu.get(genreNumber);
					List<Movie> allMovies = allMoviesList();

					filterMovies(allMovies, genreName);

					System.out.print("Continue? (y/n) ");
					String answer = scnr.nextLine().toLowerCase();
					System.out.println();

					if (!answer.equals("y")) {
						movieTime = false;
					}
				} else {
					System.out.println("Sorry, we don't have that genre. Please try again.");
					System.out.println();
				}
			} catch (InputMismatchException e) {
				scnr.nextLine();
				System.out.println("Sorry, that is an invalid input. Please enter a number.");
				System.out.println();
			}
		}
	}

	public static List<Movie> filterMovies(List<Movie> allMovies, String genreName) {
		ArrayList<Movie> specificGenre = new ArrayList<>();

		for (Movie movie : allMovies) {
			if (movie.getGenre().equals(genreName)) {
				specificGenre.add(movie);
			}
		}
		return specificGenre;
	}

	public static List<Movie> allMoviesList() {
		ArrayList<Movie> allMovies = new ArrayList<>();
		boolean checkMovie = true;

		while (checkMovie) {
			int i = 1;
			if (!MovieIO.getMovie(i).getMovieName().equals("NO SUCH MOVIE")) {
				allMovies.add(MovieIO.getMovie(i));
			}
		}
		return allMovies;
	}

}
