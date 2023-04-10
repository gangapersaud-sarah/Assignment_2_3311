import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ValidDate implements Chain{

	private  Chain nextInChain;
	
	// Defines the next Object to receive the
	// data if this one can't use it
	public void setNextChain(Chain nextChain) {
		nextInChain = nextChain;
		
	}

	// Tries to calculate the data, or passes it
	// to the Object defined in method setNextChain()
	public String validateBooking(String username, String lp, String pl, String ps, String date, String start, String duration, ArrayList<Integer> allTimes) {
		
		String[] parts = date.split("/");
		int day = Integer.valueOf(parts[0]);
		int month = Integer.valueOf(parts[1]);
		int year = Integer.valueOf(parts[2]);
		
		LocalDate givenDate = LocalDate.of(year, month, day);  
		LocalDate now = LocalDate.now();  
		
		boolean valid = givenDate.isAfter(now) || givenDate.isEqual(now);
		// check if time is after local time
		if(valid){
			return nextInChain.validateBooking(username, lp, pl, ps, date, start, duration, allTimes);
		} 
		else {	
			return "Booking not Created, date if booking is unavalible";
		}
		
	}
}
