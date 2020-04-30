package lab11;

public class Movie {
	
	private String movieName;
	private String genre;

	public Movie(String movieName, String genre) {
		this.movieName = movieName;
		this.genre = genre;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public String getGenre() {
		return genre;
	}
}
