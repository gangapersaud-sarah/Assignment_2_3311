import java.util.ArrayList;

public interface Chain {

	// Defines the next Object to receive the data
	// if this Object can't process it
	public void setNextChain(Chain nextChain);
	
	// Either solves the problem or passes the data
	// to the next Object in the chain
	public void validateBooking(String username, String lp, String pl, String ps, String date, String start, String duration, ArrayList<Integer> allTimes);
	
}
