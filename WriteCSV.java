import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class WriteCSV {
	
	
	public static void main(String[] args) {
		
		// some testing input
		// change input to test other values
		String first = "Mary";
		String last = "Nguyen";
		String email = "Mary@gmail.com";
		String pwd = "1234";
		String type = "Student";
		String username = "HappyBuddy";
		
		String lp = "Some Number";
		String pl = "A";
		String ps = "2";
		String date = "today";
		String time = "this time";
		String duration = "some time";
		
		// apply the functions (testing)
		// comment out funstions when not testing the specific function
		//saveClient(username, first, last, email, pwd, type);
		//CreateAutoAccounts(username, pwd);
		//CreateBooking(username, lp, pl, ps, date, time, duration);
		addDisabled("A", 1);
	}

	
	/**
	 * write values into CSV for actual people, clients, managers, super-managers
	 * @param username = username
	 * @param first = first name
	 * @param last = last name
	 * @param email = email
	 * @param pwd = password
	 * @param type = type of user (eg. student, faculty, managers, super-managers...)
	 */
	public static void saveClient(String username, String first, String last, String email, String pwd, String type, int amount) {
		try {
			
			// create file writers
			String filepath = "Clients.txt";
			FileWriter fw = new FileWriter(filepath , true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			// what to write in file
			pw.println(username + "," + first + "," + last + "," + email + "," + pwd + "," + type + "," + amount + ",");
			
			//push and close file
			pw.flush();
			pw.close();
			
			// update user if writing is successful
			JOptionPane.showMessageDialog(null, "User Registered");
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "User not Registered, there has been a problem with our system please try again");
		}
	}
	
	/**
	 * write values into CSV for autoAccount
	 * @param username = username
	 * @param pwd = password
	 */
	public static void CreateAutoAccounts(String username, String pwd) {
		try {
			
			// create file writers
			String filepath = "Clients.txt";
			FileWriter fw = new FileWriter(filepath , true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			// what to write in file
			pw.println(username + "," + null + "," + null + "," + null + "," + pwd + "," + "Manager"+ "," + -1 + ",");
			
			//push and close file
			pw.flush();
			pw.close();
			
			// update user if writing is successful
			JOptionPane.showMessageDialog(null, "Auto account Registered");
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "Auto account not Registered, there has been a problem with our system please try again");
		}
	}
	
	/**
	 * write values for a new Booking
	 * @param username = username
	 * @param lp = license plate
	 * @param pl = parking lot
	 * @param ps = parking space
	 * @param date = start date of booking
	 * @param time = start time
	 * @param duration = duration of booking
	 */
	public static void CreateBooking(String username, String lp, String pl, String ps, String date, String time, String duration) {
		try {
			
			// create file writers
			String filepath = "Booking.txt";
			FileWriter fw = new FileWriter(filepath , true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			// what to write in file
			pw.println(username + "," + lp + "," + pl + "," + ps + "," + date + "," + time + "," + duration);
			
			//push and close file
			pw.flush();
			pw.close();
			
			// update user if writing is successful
			JOptionPane.showMessageDialog(null, "Booking Created for " + username + " at parking Lot " + pl + " parking space " + ps +
					" from " + time + " to " + duration);
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "Booking not Created, there has been a problem with our system please try again");
		}
	}
	
	public static void addDisabled(String pl, int ps) {
		try {
			
			// create file writers
			String filepath = "Parking.txt";
			FileWriter fw = new FileWriter(filepath , true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			// what to write in file
			pw.println(pl + "," + ps);
			
			//push and close file
			pw.flush();
			pw.close();
			
			// update user if writing is successful
			JOptionPane.showMessageDialog(null, pl + "," + ps);
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "Booking not Created, there has been a problem with our system please try again");
		}
	}
}
