import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		// System
		System s = System.getInstance();
		boolean b = s.equals(null);
		assertEquals(false, b);
		
		
		// Log in
		boolean bool1 = s.doLogin("HappyBuddy77", "1234");
		boolean bool2 = s.doLogin("HappyBuddy11", "7890");
		boolean bool3 = s.doLogin("HappyBuddy22", "7890");
		boolean bool4 = s.doLogin("HappyBuddy22", "7");
		
		assertEquals(true, bool1);
		assertEquals(true, bool2);
		assertEquals(true, bool3);
		assertEquals(false, bool4);
		
		// Sign in
		s.doSignin();
		Sign_in sign = new Sign_in();
		sign.register("Red", "bcucb@gmail.com", "F", "L", "hH@", "Student");
		
		
		// Add a booking
		AddBooking a = new AddBooking();
		
		ArrayList<Integer> test = a.actionDate("Parking Lot: A", "Parking Space: 2", "13/04/2023");
		ArrayList<Integer> tester = new ArrayList<Integer>();

		for(int i = 1; i < 101; i ++) {
			tester.add(i);
		}
		
		
		test = a.actionPL("Parking Lot: A");
		assertEquals(test, tester);
		
		ArrayList<Integer> tester2 = new ArrayList<Integer>();
		tester2.add(10);
		tester2.add(13);
		tester2.add(17);
		tester2.add(20);
		tester2.add(21);
		tester2.add(22);
		
		test = a.actionPS("Parking Lot: A", "Parking Space: 2", "13/04/2023");
		assertEquals(test, tester2);
		
		
		// testing adding chain
		String testing = "";
		ArrayList<Integer> allTimes = new ArrayList<Integer>();
		Chain chainCalc1 = new ValidLP();
		Chain chainCalc2 = new ValidDate();
		Chain chainCalc3 = new ValidTime();
		
		chainCalc1.setNextChain(chainCalc2);
		chainCalc2.setNextChain(chainCalc3);
		
		testing = chainCalc1.validateBooking("HappyBuddy77", "ABC1234", "Parking Lot: A", "Parking Space: 1", "01/01/2025", "16:00 EST", "3", allTimes);
		assertEquals(testing, "Booking not Created, time and duration of booking is unavalible");
		testing = chainCalc1.validateBooking("HappyBuddy99", "ABC1234", "Parking Lot: A", "Parking Space: 1", "01/01/2025", "16:00 EST", "3", allTimes);
		assertEquals(testing, "Booking not Created, time and duration of booking is unavalible");
		testing = chainCalc1.validateBooking("HappyBuddy66", "ABC1234", "Parking Lot: A", "Parking Space: 1", "01/01/2025", "16:00 EST", "3", allTimes);
		assertEquals(testing, "Booking not Created, time and duration of booking is unavalible");
		testing = chainCalc1.validateBooking("HappyBuddy92", "ABC1234", "Parking Lot: A", "Parking Space: 1", "01/01/2025", "16:00 EST", "3", allTimes);

		//view booking
		View_Bookings v = new View_Bookings();
		v.edit("ABC1234", "Parking Lot: A", "Parking Space: 1", "01/01/2025", "16:00 EST", "3");
		v.extend("ABC1234", "Parking Lot: A", "Parking Space: 1", "01/01/2025", "16:00 EST", "3");
		
		// Logic testing for read booking tests for adding
		ArrayList<ArrayList<String>> testingArrofArr = ReadCSV.notDeleteBookings("HappyBuddy77", "ABC1234", "A", "1", "01/01/2025", "16:00 EST", "3");
		ArrayList<ArrayList<String>> testingArrofArr2 = ReadCSV.notDeleteClients("HappyBuddy77");
		ArrayList<ArrayList<String>> testingArrofArr3 = ReadCSV.findBookings("HappyBuddy77", "Booking.txt");
		ArrayList<ArrayList<String>> testingArrofArr4 = ReadCSV.findUserType("Staff", "Clients.txt");
				
		ArrayList<String> testerArrofArr = new ArrayList<String>();
		testerArrofArr.add("HappyBuddy77");
		testerArrofArr.add("L2CP02");
		testerArrofArr.add("A");
		testerArrofArr.add("2");
		testerArrofArr.add("13/04/2023");
		testerArrofArr.add("14");
		testerArrofArr.add("3");
		
		assertEquals(testingArrofArr.get(0), testerArrofArr);
		//assertEquals(testingArrofArr2.get(0), testerArrofArr);
		//assertEquals(testingArrofArr3.get(0), testerArrofArr);
		
		testerArrofArr.removeAll(testerArrofArr);
		testerArrofArr.add("HappyBuddy92");
		testerArrofArr.add("Sarah");
		testerArrofArr.add("B");
		testerArrofArr.add("Sarah@gmail.com");
		testerArrofArr.add("9012");
		testerArrofArr.add("Staff");
		testerArrofArr.add("0\r");
		assertEquals(testingArrofArr4.get(0), testerArrofArr);
		//assertEquals(testingArrofArr2, "Booking not Created, time and duration of booking is unavalible");

	}

}

