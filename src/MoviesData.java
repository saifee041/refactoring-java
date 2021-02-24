import java.util.HashMap;
import java.util.Map;

public enum MoviesData {

	F001("You've Got Mail", "regular"),
	F002("Matrix", "regular"),
	F003("Cars", "childrens"),
	F004("Fast & Furious X", "new");

    private static final Map<String, MoviesData> BY_MOVIE = new HashMap<String, MoviesData>();
    private static final Map<String, MoviesData> BY_TYPE = new HashMap<String, MoviesData>();
    
    public final String movieName;
    public final String movieType;
    
    static {
        for (MoviesData e : values()) {
        	BY_MOVIE.put(e.movieName, e);
        	BY_TYPE.put(e.movieType, e);
        }
    }
    
    private MoviesData(String movieName,String movieType) {
        this.movieName = movieName;
        this.movieType = movieType;
    }
    
    public static MoviesData valueOfMovieName(String movieName) {
        return BY_MOVIE.get(movieName);
    }

    public static MoviesData valueOfMovieType(String movieType) {
        return BY_TYPE.get(movieType);
    }

}
