import java.util.List;

public class Customer {
    private String customerName;
    private List<MovieRental> moviesRented;

    public Customer(String customerName, List<MovieRental> moviesRented) {
        this.customerName = customerName;
        this.moviesRented = moviesRented;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<MovieRental> getMoviesRented() {
        return moviesRented;
    }
}
