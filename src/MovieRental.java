public class MovieRental {
    private String movieName;
    private int rentedDays;

    public MovieRental(String movieName, int rentedDays) {
        this.movieName = movieName;
        this.rentedDays = rentedDays;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getRentedDays() {
        return rentedDays;
    }
}
