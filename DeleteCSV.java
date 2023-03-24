import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DeleteCSV {
	
	private static Scanner x;
	public static void main(String[] args) {
		
		// some testing input
		// change input to test other values
		String first = "Mary";
		String last = "Nguyen";
		String email = "Mary@gmail.com";
		String pwd = "1234";
		String type = "Student";
		String username = "HappyBuddy";
		
		String lp = "L2CP02";
		String pl = "A";
		String ps = "2";
		String date = "13/03/2023";
		String time = "14";
		String duration = "3";
		
		// apply the functions (testing)
		// comment out funstions when not testing the specific function
		//saveClient(username, first, last, email, pwd, type);
		//CreateAutoAccounts(username, pwd);
		//CreateBooking(username, lp, pl, ps, date, time, duration);
		//addDisabled("A", 1);
	}
	
	
	/**
	 * @param username
	 * @param lp
	 * @param pl
	 * @param ps
	 * @param date
	 * @param time
	 * @param duration
	 * @throws IOException 
	 */
	public static void CancelBooking(String username, String lp, String pl, String ps, String date, String time, String duration) throws IOException {
			
		File oldFile = new File("Booking.txt");
		
			String usernameC = "";
			String lpC = "";
			String plC = "";
			String psC = "";
			String dateC = "";
			String timeC = "";
			String durationC = "";
			
			try {
				
				
				//BufferedWriter bw = new BufferedWriter(fw);
				//PrintWriter pw = new PrintWriter(bw);
				ArrayList<ArrayList<String>> arr = ReadCSV.notDeleteBookings(username, lp, pl, ps, date, time, duration);
				//ReadCSV.notDeleteBookings(usernameC, lpC, plC, psC, dateC, timeC, durationC);

				FileWriter fw = new FileWriter(oldFile , false);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				
				for (int i = 0; i < arr.size(); i ++) {
					usernameC = arr.get(i).get(0);
					lpC = arr.get(i).get(1);
					plC = arr.get(i).get(2);
					psC = arr.get(i).get(3);
					dateC = arr.get(i).get(4);
					timeC = arr.get(i).get(5);
					durationC = arr.get(i).get(6);
					pw.println(usernameC + "," + lpC + "," + plC + "," + psC + "," + dateC + "," + timeC + "," + durationC);
				}
				
//				// create reading tools, x is the file
//				x = new Scanner(oldFile);
//				// Separate values in x using "," and "\n"
//				x.useDelimiter("[,\n]");
//				
//				while (x.hasNext()) {
//					
//					// get next line
//					usernameC = x.next();
//					lpC = x.next();
//					plC = x.next();
//					psC = x.next();
//					dateC = x.next();
//					timeC = x.next();
//					durationC = x.next();
//					
//					// when booking is found (unique usernames)
//					if(!(usernameC.equals(username) && lpC.equals(lp) && plC.equals(pl) && psC.equals(ps) 
//							&& dateC.equals(date) && timeC.equals(time) && durationC.equals(duration))) {
//						// add the booking details to the array
//						fw.write(usernameC + "," + lpC + "," + plC + "," + psC + "," + dateC + "," + timeC + "," + durationC);
//					}
//				}
				
//				x.close();
				pw.flush();
				pw.close();
				bw.flush();
				bw.close();
				//bw.close();
				
			}
			catch (Exception e){
				
			}
		
//		File inputFile = new File("Booking.txt");
//		File tempFile = new File("temp.txt");
//
//		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//
//		String lineToRemove = username + "," + lp + "," + pl + "," + ps + "," + date + "," + time + "," + duration;
//		String currentLine;
//
//		while((currentLine = reader.readLine()) != null) {
//		    // trim newline when comparing with lineToRemove
//		    String trimmedLine = currentLine.trim();
//		    if(trimmedLine.equals(lineToRemove)) continue;
//		    writer.write(currentLine + System.getProperty("line.separator"));
//		}
//		writer.close(); 
//		reader.close(); 
//		Path p = Paths.get("Booking.txt");
//		Files.delete(p);
//		boolean successful = tempFile.renameTo(inputFile);
	}
	
	public static void CancelClient(String username, String first, String last, String email, String pw, String type, String amountDue) throws IOException {
		
		File oldFile = new File("Clients.txt");
		
			String usernameC = "";
			String firstC = "";
			String lastC = "";
			String emailC = "";
			String pwC = "";
			String typeC = "";
			String amountDueC = "";
			
			try {
				ArrayList<ArrayList<String>> arr = ReadCSV.notDeleteClients(username);
				ReadCSV.notDeleteClients(username);

				FileWriter fw = new FileWriter(oldFile , false);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw2 = new PrintWriter(bw);
				
				for (int i = 0; i < arr.size(); i ++) {
					usernameC = arr.get(i).get(0);
					firstC = arr.get(i).get(1);
					lastC = arr.get(i).get(2);
					emailC = arr.get(i).get(3);
					pwC = arr.get(i).get(4);
					typeC = arr.get(i).get(5);
					amountDueC = arr.get(i).get(6);
					pw2.println(usernameC + "," + firstC + "," + lastC + "," + emailC + "," + pwC + "," + typeC + "," + amountDueC);
				}

				bw.flush();
				bw.close();
				pw2.flush();
				pw2.close();
				//fw.flush();
				//fw.close();
				JOptionPane.showMessageDialog(null, "user deleted");
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "error");
			}
	}

	public static void RemoveParkingEntry(String name, int val){
		try {
			//arr = every parking lot info except Parking Lot: name
			ArrayList<ArrayList<String>> arr = ReadCSV.notDeleteParking(name, val);
			FileWriter fw = new FileWriter("Parking.txt" , false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw2 = new PrintWriter(bw);
			
			for (int i = 0; i < arr.size(); i ++){
				pw2.println(arr.get(i).get(0) + "," + arr.get(i).get(1));
			}

			bw.flush();
			bw.close();
			pw2.flush();
			pw2.close();

			JOptionPane.showMessageDialog(null, "Parking Lot: " + name + " entries deleted");
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "error");
		}
	}
	
	
	public static void RemoveValidateClient(String username) throws IOException {
		
		File oldFile = new File("validateClients.txt");
		
			String usernameC = "";
			String firstC = "";
			String lastC = "";
			String emailC = "";
			String pwC = "";
			String typeC = "";
			String amountDueC = "";
			
			try {
				ArrayList<ArrayList<String>> arr = ReadCSV.notDeleteClients(username);
				//ReadCSV.notDeleteClients(username);

				FileWriter fw = new FileWriter(oldFile , false);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw2 = new PrintWriter(bw);
				
				for (int i = 0; i < arr.size(); i ++) {
					usernameC = arr.get(i).get(0);
					firstC = arr.get(i).get(1);
					lastC = arr.get(i).get(2);
					emailC = arr.get(i).get(3);
					pwC = arr.get(i).get(4);
					typeC = arr.get(i).get(5);
					amountDueC = arr.get(i).get(6);
					pw2.println(usernameC + "," + firstC + "," + lastC + "," + emailC + "," + pwC + "," + typeC + "," + amountDueC);
				}

				bw.flush();
				bw.close();
				pw2.flush();
				pw2.close();
				//fw.flush();
				//fw.close();
				JOptionPane.showMessageDialog(null, "Validate-User deleted");
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "error");
			}
	}
}

//
