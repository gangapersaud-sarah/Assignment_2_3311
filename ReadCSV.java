import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ReadCSV {
	
	private static Scanner x;
	
	// testing delete later
	public static void main(String[]args) {
		String filepath = "Clients.txt";
		String username = "HappyBuddy88";
		String type = "Manager";
		
		findUserName(username, filepath);
		findUserType(type, filepath);
		//allUsers(filepath);
	}

	
	/**
	 * reading the client CSV
	 * @param findUsername = username (unique) of the user we want to find
	 * @param filepath = Clients.txt
	 * @return the string array containing {username, firstname, lastname, email, password, type}
	 */
	public static ArrayList<String> findUserName(String findUsername, String filepath) {
		
		boolean found = false;
		ArrayList<String> returnList = new ArrayList<String>();
		String username = "";
		String first = "";
		String last = "";
		String email = "";
		String pwd = "";
		String type = "";
		
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File(filepath));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\n\r]");
			
			while (x.hasNext() && !found) {
				
				// get next line
				username = x.next();
				first = x.next();
				last = x.next();
				email = x.next();
				pwd = x.next();
				type = x.next();
				
				// when user is found (unique usernames)
				if(username.equals(findUsername)) {
					found = true;
					
					// add the user details to the array
					returnList.add(username);
					returnList.add(first);
					returnList.add(last);
					returnList.add(email);
					returnList.add(pwd);
					returnList.add(type);
				}
			}
			
			if(found) {
				JOptionPane.showMessageDialog(null, username + ", " + first + ", " + last + ", " + email + ", " + pwd + ", " + type);
			}
		}
		catch (Exception e){
			
		}
		return returnList;
	}
	
	/**
	 * reading the client CSV
	 * @param findUsername = username (unique) of the user we want to find
	 * @param filepath = Clients.txt
	 * @return the string array containing {username, firstname, lastname, email, password, type}
	 */
	public static ArrayList<ArrayList<String>> findUserType(String findtype, String filepath) {
		
		ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>();
		String username = "";
		String first = "";
		String last = "";
		String email = "";
		String pwd = "";
		String type = "";
		
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File(filepath));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\n]");
			
			while (x.hasNext()) {
				
				// get next line
				username = x.next();
				first = x.next();
				last = x.next();
				email = x.next();
				pwd = x.next();
				type = x.next();
				
				// when user is found (unique usernames)
				if(type.equals(findtype)) {
					ArrayList<String> list = new ArrayList<String>();
					// add the user details to the array
					list.add(username);
					list.add(first);
					list.add(last);
					list.add(email);
					list.add(pwd);
					list.add(type);
					
					returnList.add(list);
					
					JOptionPane.showMessageDialog(null, username + ", " + first + ", " + last + ", " + email + ", " + pwd + ", " + type);

				}
			}
			
		}
		catch (Exception e){
			
		}
		return returnList;
	}
	
		/**
		 * reading the Booking CSV
		 * @param findUsername = username (unique) of the user we want to find
		 * @param filepath = Bookings.txt
		 * @return the string array containing {username, license plate, parking lot, parking space, date, time, duration}
		 */
		public static ArrayList<String> findBooking(String findUsername, String filepath) {
			
			boolean found = false;
			ArrayList<String> returnList = new ArrayList<String>();
			String username = "";
			String lp = "";
			String pl = "";
			String ps = "";
			String date = "";
			String time = "";
			String duration = "";
			
			try {
				
				// create reading tools, x is the file
				x = new Scanner(new File(filepath));
				// Separate values in x using "," and "\n"
				x.useDelimiter("[,\n]");
				
				while (x.hasNext() && !found) {
					
					// get next line
					username = x.next();
					lp = x.next();
					pl = x.next();
					ps = x.next();
					date = x.next();
					time = x.next();
					duration = x.next();
					
					// when booking is found (unique usernames)
					if(username.equals(findUsername)) {
						found = true;
						// add the booking details to the array
						returnList.add(username);
						returnList.add(lp);
						returnList.add(pl);
						returnList.add(ps);
						returnList.add(date);
						returnList.add(time);
						returnList.add(duration);
						
						
					}
				}
				
				if(found) {
					JOptionPane.showMessageDialog(null, username + ", " + lp + ", " + pl + ", " + ps + ", " + date + ", " + time + ", " + duration);
				}
			}
			catch (Exception e){
				
			}
			return returnList;
		}
	
	/**
	 * return all users of the client CSV
	 * @param filepath
	 * @return an Array list of array lists, every user
	 */
	public static ArrayList<ArrayList<String>> allUsers(String filepath) {
	
		ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>();
		String username = "";
		String first = "";
		String last = "";
		String email = "";
		String pwd = "";
		String type = "";
		
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File(filepath));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\n]");
			
			while (x.hasNext()) {
				
				// get next line
				username = x.next();
				first = x.next();
				last = x.next();
				email = x.next();
				pwd = x.next();
				type = x.next();
				
				ArrayList<String> list = new ArrayList<String>();
				// add the user details to the array
				list.add(username);
				list.add(first);
				list.add(last);
				list.add(email);
				list.add(pwd);
				list.add(type);
				
				// add the user (array list of details) to the arraylist of users
				returnList.add(list);
				
			}
			
		}
		catch (Exception e){
			
		}
		return returnList;
	}
	
	public static ArrayList<ArrayList<String>> allBookings(String filepath) {
	
		
		ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>();
		String username = "";
		String lp = "";
		String pl = "";
		String ps = "";
		String date = "";
		String time = "";
		String duration = "";
		
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File(filepath));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\n]");
			
			while (x.hasNext()) {
				
				// get next line
				username = x.next();
				lp = x.next();
				pl = x.next();
				ps = x.next();
				date = x.next();
				time = x.next();
				duration = x.next();
				
				ArrayList<String> list = new ArrayList<String>();
				// add the user details to the array
				list.add(username);
				list.add(lp);
				list.add(pl);
				list.add(ps);
				list.add(date);
				list.add(time);
				list.add(duration);
				
				// add the booking (array list of details) to the arraylist of bookings
				returnList.add(list);
				
			}
			
		}
		catch (Exception e){
			
		}
		return returnList;
	}


	public static String[] allParkingLots(){
	String parkingLot = "";
	ArrayList<String> returnList = new ArrayList<String>();
	try {
		
		// create reading tools, x is the file
		x = new Scanner(new File("Parking.txt"));
		// Separate values in x using "," and "\n"
		x.useDelimiter("[,\n]");


		String prev = "";
		// Return List
		while (x.hasNext()) {
			//Get next Character.
			parkingLot = x.nextLine();
			//JOptionPane.showMessageDialog(null, parkingLot);
			parkingLot = parkingLot.substring(0, 1);
			//JOptionPane.showMessageDialog(null, parkingLot);
			//Check if it's a unique name
			if (!parkingLot.equals(prev)){
				//add parking lot name to list and update prev
				returnList.add("Parking Lot " + parkingLot);
				prev = parkingLot;
			}			
		}
		
	}
	catch (Exception e){
		
	}
	//return list as String array
	return returnList.toArray(new String[0]);
}

public static String[] allParking(){
	String parking = "";
	ArrayList<String> returnList = new ArrayList<String>();
	try {
		
		// create reading tools, x is the file
		x = new Scanner(new File("Parking.txt"));
		// Separate values in x using "," and "\n"
		x.useDelimiter("[,\n]");


		String prev = "";
		// Return List
		while (x.hasNext()) {
			//Get next Character.
			parking = x.nextLine();

			//parking = A,1
			//String[] split = parking.split(",");
			parking = parking.substring(0, 1);
			//Check if it's a unique name
			if (!parking.equals(prev)){
				//add parking lot name to list and update prev
				returnList.add("Parking Lot " + parking);
				prev = parking;
			}			
		}
		
	}
	catch (Exception e){
		
	}
	//return list as String array
	return returnList.toArray(new String[0]);
}
}
