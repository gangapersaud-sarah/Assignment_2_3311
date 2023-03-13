import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ReadCSV {
	
	private static Scanner x;
	
	// testing delete later
	public static void main(String[]args) {
		String filepath = "Clients.txt";
		String username = "HappyBuddy99";
		
		findUser(username, filepath);
	}
	
	// reading the client CSV
	/**
	 * @param findUsername = username (unique) of the user we want to find
	 * @param filepath = Clients.txt
	 * @return the string array containing {username, firstname, lastname, email, password, type}
	 */
	public static ArrayList<String> findUser(String findUsername, String filepath) {
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
			x.useDelimiter("[,\n]");
			
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

}
