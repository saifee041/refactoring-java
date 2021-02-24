import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RentalInfo {

	private double amountDue = 0;
	private double totalAmount = 0;
	private int frequentBonusPoints = 0;
	private String movieStatus = "";
	String rentalMovieInfo = "";

	public double getTotalAmount() {
		return totalAmount;
	}

	public int getFrequentBonusPoints() {
		return frequentBonusPoints;
	}

	public String statement(Customer customer) {

		rentalMovieInfo = "Rental Record for " + customer.getCustomerName() + "\n";
				
		for (MovieRental rentedMovie : customer.getMoviesRented()) {

			String movieName = rentedMovie.getMovieName();

			// Determine the amount of each movie
			if (MoviesData.valueOfMovieName(movieName).movieType.equalsIgnoreCase("REGULAR")) {
				movieStatus = "REGULAR";
				amountDue = 2;
				amountDue += calculateTotalAmount(rentedMovie.getRentedDays(), movieStatus);
			} else if (MoviesData.valueOfMovieName(movieName).movieType.equalsIgnoreCase("NEW")) {
				movieStatus = "NEW";
				amountDue = calculateTotalAmount(rentedMovie.getRentedDays(), movieStatus);
			} else if (MoviesData.valueOfMovieName(movieName).movieType.equalsIgnoreCase("CHILDRENS")) {
				movieStatus = "CHILDRENS";
				amountDue = 1.5;
				amountDue += calculateTotalAmount(rentedMovie.getRentedDays(), movieStatus);
			}

			// Adding Bonus Points
			++frequentBonusPoints;
			totalAmount += amountDue;

			// Print Figures For Rental
			rentalMovieInfo += "\t" + rentedMovie.getMovieName() + "\t" + amountDue + "\n";
		}
		
		// add footer lines
		rentalMovieInfo += "Amount owed is " + totalAmount + "\n";
		rentalMovieInfo += "You earned " + frequentBonusPoints + " frequent points\n";
		
		return rentalMovieInfo;

	}

	private double calculateTotalAmount(int rentedDays, String movieStatus) {
		double amountDue = 0;
		int paidDays = 0;
		if (rentedDays > 2) {
			if (movieStatus.equalsIgnoreCase("REGULAR")) {
				paidDays = rentedDays - 2;
				amountDue = paidDays * 1.5;
			} else if (movieStatus.equalsIgnoreCase("NEW")) {
				amountDue = rentedDays * 3;
				++frequentBonusPoints;
			} else if (movieStatus.equalsIgnoreCase("CHILDRENS")) {
				paidDays = rentedDays - 3;
				amountDue = paidDays * 1.5;
			}
		}
		return amountDue;
	}

}
