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
		
		//findUserName(username, filepath);
		//findUserType(type, filepath);
		//allUsers(filepath);
//		String[] list = parkingSpacesOfLot("A");
//		for(int i = 0; i < list.length; i++) {
//			System.out.println(list[i]);
//		}
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
		String amount = "";
		
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File(filepath));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\n]");
			
			while (x.hasNext() && !found) {
				
				// get next line
				username = x.next();
				first = x.next();
				last = x.next();
				email = x.next();
				pwd = x.next();
				type = x.next();
				amount = x.next();
				
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
					returnList.add(amount);
				}
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
		String amount = "";
		
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
				amount = x.next();
				
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
					list.add(amount);
					
					returnList.add(list);
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
		public static ArrayList<ArrayList<String>> findBookings(String findUsername, String filepath) {
			
			ArrayList<String> returnList = new ArrayList<String>();
			ArrayList<ArrayList<String>> returnList2 = new ArrayList<ArrayList<String>>();
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
					
					// when booking is found (unique usernames)
					if(username.equals(findUsername)) {
						// add the booking details to the array
						returnList.add(username);
						returnList.add(lp);
						returnList.add(pl);
						returnList.add(ps);
						returnList.add(date);
						returnList.add(time);
						returnList.add(duration);	
						
						returnList2.add(returnList);
					}
					
				}
			}
			catch (Exception e){
				
			}
			return returnList2;
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
		String amount = "";
		
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
				amount = x.next();
				
				ArrayList<String> list = new ArrayList<String>();
				// add the user details to the array
				list.add(username);
				list.add(first);
				list.add(last);
				list.add(email);
				list.add(pwd);
				list.add(type);
				list.add(amount);
				
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
		String parkingSpace = "";
		ArrayList<String> returnList = new ArrayList<String>();
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File("Parking.txt"));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\n]");

			// Return List
			while (x.hasNext()) {
				//Get next Character.
				parkingLot = x.next();
				parkingSpace = x.next();
				//parking = A,1
				//Check if it's a unique name
				if (!returnList.contains(parkingLot)){
					//add parking lot name to list and update prev
					returnList.add(parkingLot);
				}			
			}
			
		}
	catch (Exception e){
		
	}
	//return list as String array
	return returnList.toArray(new String[0]);
}

	public static String[] allParkingSpaces(){
		String parkingLot = "";
		String parkingSpace = "";
		ArrayList<String> returnList = new ArrayList<String>();
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File("Parking.txt"));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\n]");
	
			// Return List
			while (x.hasNext()) {
				//Get next Character.
				parkingLot = x.next();
				parkingSpace = x.next();
				//parking = A,1
				//Check if it's a unique name
				if (!returnList.contains(parkingSpace)){
					//add parking lot name to list and update prev
					returnList.add(parkingSpace);
				}			
			}
			
		}
		catch (Exception e){
			
		}
		//return list as String array
		return returnList.toArray(new String[0]);
	}
	
	public static String[] parkingSpacesOfLot(String a){
		String parkingLot = "";
		String parkingSpace = "";
		ArrayList<String> returnList = new ArrayList<String>();
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File("Parking.txt"));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\n]");
	
			// Return List
			while (x.hasNext()) {
				//Get next Character.
				parkingLot = x.next();
				parkingSpace = x.next();
				//parking = A,1
				//Check if it's a unique name
				if (!returnList.contains(parkingSpace) && parkingLot.equals(a)){
					//add parking lot name to list and update prev
					returnList.add(parkingSpace);
				}			
			}
			
		}
		catch (Exception e){
			
		}
		//return list as String array
		return returnList.toArray(new String[0]);
	}

	public static String[] allParking(){
		ArrayList<String> returnList = new ArrayList<String>();
		try {
			// create reading tools, x is the file
			x = new Scanner(new File("Parking.txt"));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\n]");
			while(x.hasNext()){
				returnList.add(x.nextLine());
			}
		}
		catch (Exception e){
			
		}
		return returnList.toArray(new String[0]);
	}
	
	public static ArrayList<ArrayList<String>> notDeleteBookings(String username, String lp, String pl, String ps, String date, String time, String duration) {
	
		
		ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>();
		String usernameC = "";
		String lpC = "";
		String plC = "";
		String psC = "";
		String dateC = "";
		String timeC = "";
		String durationC = "";
		
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File("Booking.txt"));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\r]");
			
			while (x.hasNext()) {
				
				// get next line
				usernameC = x.next();
				lpC = x.next();
				plC = x.next();
				psC = x.next();
				dateC = x.next();
				timeC = x.next();
				durationC = x.next();
				
				if(usernameC.contains("\n")) {
					String[] parts = usernameC.split("\n");
			    	usernameC = parts[1];
				}
				
				if(!(usernameC.equals(username) && lpC.equals(lp) && plC.equals(pl) && psC.equals(ps) 
						&& dateC.equals(date) && timeC.equals(time) && durationC.equals(duration))) {
					// add the booking details to the array
					ArrayList<String> list = new ArrayList<String>();
					// add the user details to the array
					list.add(usernameC);
					list.add(lpC);
					list.add(plC);
					list.add(psC);
					list.add(dateC);
					list.add(timeC);
					list.add(durationC);
					
					// add the booking (array list of details) to the arraylist of bookings
					returnList.add(list);
				}	
				
			}
		}
		catch (Exception e){
			
		}
		return returnList;
	}
	
	public static ArrayList<ArrayList<String>> notDeleteClients(String username) {
	
		
		ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>();
		String usernameC = "";
		String first = "";
		String last = "";
		String email = "";
		String pw = "";
		String type = "";
		String amountDue = "";
		
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File("Clients.txt"));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\r]");
			
			while (x.hasNext()) {
				
				// get next line
				usernameC = x.next();
				first = x.next();
				last = x.next();
				email = x.next();
				pw = x.next();
				type = x.next();
				amountDue = x.next();
				
				if(usernameC.contains("\n")) {
					String[] parts = usernameC.split("\n");
			    	usernameC = parts[1];
				}
				if(!(usernameC.equals(username))) {
					// add the booking details to the array
					ArrayList<String> list = new ArrayList<String>();
					// add the user details to the array
					list.add(usernameC);
					list.add(first);
					list.add(last);
					list.add(email);
					list.add(pw);
					list.add(type);
					list.add(amountDue);
					
					// add the booking (array list of details) to the arraylist of bookings
					returnList.add(list);
				}
				
				
			}
		}
		catch (Exception e){
			
		}
		return returnList;
	}

	public static ArrayList<ArrayList<String>> notDeleteParking(String name, int value) {
	
		
		ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>();
		String LotName= "";
		int val = 0;
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File("Parking.txt"));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\r]");
			
			while (x.hasNextLine()) {
				String temp = x.nextLine();
				LotName = temp.split(",")[0];
				val = Integer.valueOf(temp.split(",")[1]);
				
				
				if(LotName.contains("\n")) {
					String[] parts = LotName.split("\n");
			    	LotName = parts[1];
				}

				if(!(LotName.equals(name))) {
					// add the booking details to the array
					ArrayList<String> list = new ArrayList<String>();
					// add the user details to the array
					list.add(LotName);
					list.add(String.valueOf(val));
					
					// add the booking (array list of details) to the arraylist of bookings
					returnList.add(list);
				}
				else{
					if(value == -1){
						if (val != -1){
							ArrayList<String> list = new ArrayList<String>();
							// add the user details to the array
							list.add(LotName);
							list.add(String.valueOf(val));
							
							// add the booking (array list of details) to the arraylist of bookings
							returnList.add(list);
						}
					}
				}
				
			}
		}
		catch (Exception e){
			
		}
		return returnList;
	}


	public static ArrayList<ArrayList<String>> notDeleteValidateClients(String username) {
	
		
		ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>();
		String usernameC = "";
		String first = "";
		String last = "";
		String email = "";
		String pw = "";
		String type = "";
		String amountDue = "";
		
		try {
			
			// create reading tools, x is the file
			x = new Scanner(new File("validateClients.txt"));
			// Separate values in x using "," and "\n"
			x.useDelimiter("[,\r]");
			
			while (x.hasNext()) {
				
				// get next line
				usernameC = x.next();
				first = x.next();
				last = x.next();
				email = x.next();
				pw = x.next();
				type = x.next();
				amountDue = x.next();
				
				if(usernameC.contains("\n")) {
					String[] parts = usernameC.split("\n");
			    	usernameC = parts[1];
				}
				if(!(usernameC.equals(username))) {
					// add the booking details to the array
					ArrayList<String> list = new ArrayList<String>();
					// add the user details to the array
					list.add(usernameC);
					list.add(first);
					list.add(last);
					list.add(email);
					list.add(pw);
					list.add(type);
					list.add(amountDue);
					
					// add the booking (array list of details) to the arraylist of bookings
					returnList.add(list);
				}
				
				
			}
		}
		catch (Exception e){
			
		}
		return returnList;
	}

	
}