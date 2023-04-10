import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ValidLP implements Chain{

	private  Chain nextInChain;
	
	// Defines the next Object to receive the
	// data if this one can't use it
	public void setNextChain(Chain nextChain) {
		nextInChain = nextChain;
		
	}

	// Tries to calculate the data, or passes it
	// to the Object defined in method setNextChain()
	public String validateBooking(String username, String lp, String pl, String ps, String date, String start, String duration, ArrayList<Integer> allTimes) {
		boolean valid = false;
		
		if(lp.length() == 7 && lp.matches("(.*)[0-9](.*)")) {
			valid = true;
		}
		if(valid){
			return nextInChain.validateBooking(username, lp, pl, ps, date, start, duration, allTimes);
		} 
		else {	
			return "Booking not Created, license plate invalid";
		}
		
	}
}

