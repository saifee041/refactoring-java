public class Movie {
    private String movieName;
    private String movieId;
    private String movieCode;

    public Movie(String movieName, String movieId,  String movieCode) {

        this.movieName = movieName;
        this.movieId = movieId;
        this.movieCode= movieCode;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieId() {
        return movieId;
    }

	public String getMovieCode() {
		return movieCode;
	}
    
}