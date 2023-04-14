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

	@SuppressWarnings("deprecation")
	@Test
	public void test1() {
		
		//manager medium 
		manager_medium m = manager_medium.getInstance();
		boolean b1 = m.equals(null);
		assertEquals(false,b1);
		
		//super manager main page
		superManagerMainPage sm = superManagerMainPage.getInstance();
		boolean b2 = sm.equals(null);
		assertEquals(false,b2);
		
		//create auto account test
		createAutoAccount s = new createAutoAccount();
		WriteCSV.CreateAutoAccounts("test_user1", "test_pass1");
		ArrayList<String> returnList = new ArrayList<String>();
		ArrayList<String> assertionList = new ArrayList<String>();
		returnList = ReadCSV.findUserName("test_user1", "Clients.txt");
		assertionList.add("test_user1");
		assertionList.add("null");
		assertionList.add("null");
		assertionList.add("null");
		assertionList.add("test_pass1");
		assertionList.add("Manager");
		assertionList.add("-1\r");
		assertEquals(assertionList,returnList);
		
		//view auto account test
		viewAutoAccount v = new viewAutoAccount();
		//number of rows(at the time of this running there should only be 7, 6 in clients.txt and one made prior)
		int numberRows = v.numberRows();
		assertEquals(7,numberRows);
		
		//number of columns(this remains consistent)
		int numberColumns = v.numberColumns();
		assertEquals(7,numberColumns);
	    
		//elements in list
		Object[] row = new Object[7];
		row = v.getAutoAccount(0);
		String[] test1 = {"HappyBuddy11","null","null","null","7890","Manager","-1"};
		assertEquals(row[0],test1[0]);
		assertEquals(row[1],test1[1]);
		assertEquals(row[2],test1[2]);
		assertEquals(row[3],test1[3]);
		assertEquals(row[4],test1[4]);
		assertEquals(row[5],test1[5]);
		
		row = v.getAutoAccount(1);
		String[] test11 = {"e2xb4qma4q","null","null","null","NZ#86l6lDX","Manager","-1"};
		assertEquals(row[0],test11[0]);
		assertEquals(row[1],test11[1]);
		assertEquals(row[2],test11[2]);
		assertEquals(row[3],test11[3]);
		assertEquals(row[4],test11[4]);
		assertEquals(row[5],test11[5]);
		
		row = v.getAutoAccount(2);
		String[] test111 = {"ps3ncq640g","null","null","null","z^UA8L1%Nj","Manager","-1"};
		assertEquals(row[0],test111[0]);
		assertEquals(row[1],test111[1]);
		assertEquals(row[2],test111[2]);
		assertEquals(row[3],test111[3]);
		assertEquals(row[4],test111[4]);
		assertEquals(row[5],test111[5]);
		
		row = v.getAutoAccount(3);
		String[] test1111 = {"HappyBuddy"," null"," null"," null"," 1234","Manager","-1"};
		assertEquals(row[0],test1111[0]);
		assertEquals(row[1],test1111[1]);
		assertEquals(row[2],test1111[2]);
		assertEquals(row[3],test1111[3]);
		assertEquals(row[4],test1111[4]);
		assertEquals(row[5],test1111[5]);
		
		row = v.getAutoAccount(4);
		String[] test11111 = {"6fbl67p19h"," null"," null"," null"," wKr9J^y%7B","Manager","-1"};
		assertEquals(row[0],test11111[0]);
		assertEquals(row[1],test11111[1]);
		assertEquals(row[2],test11111[2]);
		assertEquals(row[3],test11111[3]);
		assertEquals(row[4],test11111[4]);
		assertEquals(row[5],test11111[5]);
		
		row = v.getAutoAccount(5);
		String[] test111111 = {"z4s97ff1e6","null","null","null","jeE7!KBGVo","Manager","-1"};
		assertEquals(row[0],test111111[0]);
		assertEquals(row[1],test111111[1]);
		assertEquals(row[2],test111111[2]);
		assertEquals(row[3],test111111[3]);
		assertEquals(row[4],test111111[4]);
		assertEquals(row[5],test111111[5]);
		
		row = v.getAutoAccount(6);
		String[] test1111111 = {"test_user1","null","null","null","test_pass1","Manager","-1"};
		assertEquals(row[0],test1111111[0]);
		assertEquals(row[1],test1111111[1]);
		assertEquals(row[2],test1111111[2]);
		assertEquals(row[3],test1111111[3]);
		assertEquals(row[4],test1111111[4]);
		assertEquals(row[5],test1111111[5]);
		
		
	}

	@Test
	public void testEE(){
				// System
				System s = System.getInstance();
				boolean b = s.equals(null);
				assertEquals(false, b);
				
				
				// Log in
				boolean bool1 = s.doLogin("HappyBuddy77", "1234");
				assertEquals(true, bool1);
				
				// Sign in
				s.doSignin();
				Sign_in sign = new Sign_in();
				sign.register("Red", "bcucb@gmail.com", "F", "L", "hH@", "Student");
				
				
				// Add a booking
				AddBooking a = new AddBooking();
				
				ArrayList<Integer> test = a.actionDate("Parking Lot: A", "Parking Space: 1", "13/04/2023");
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
				
				test = a.actionPS("Parking Lot: A", "Parking Space: 1", "13/04/2023");
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
				
				//view booking
				View_Bookings v = new View_Bookings();
				v.edit("ABC1234", "Parking Lot: A", "Parking Space: 1", "01/01/2025", "16:00 EST", "3");
				
				//edit booking
				EditBooking edit = new EditBooking();
				edit.username = "HappyBuddy77";
				edit.lp = "123ABC";
				edit.pl = "A";
				edit.ps = "1";
				edit.date = "01/01/2025";
				edit.time = "18:00 EST";
				edit.duration = "3";
				
				ArrayList<ArrayList<String>> testingArrofArr = ReadCSV.notDeleteBookings("HappyBuddy77", "123ABC", "A", "1", "01/01/2025", "18:00 EST", "3");
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
				
				
				
				v.extend("123ABC", "Parking Lot: A", "Parking Space: 1", "01/01/2025", "18:00 EST", "3");
				ExtendBooking extend = new ExtendBooking();
				extend.setLP("123ABC");
				extend.setPL("Parking Lot: A");
			    extend.setPS("Parking Space: 1");
			    extend.setDate("01/01/2025");
			    extend.setTime("18:00 EST");
			    extend.setDuration("5");
			       
			    // Extend booking from 3 to 5 hours
			    //extend.comboBox.setSelectedIndex(4); // 5 hours
			    //extend.btnNewButton.doClick();
			        
			    // Check that the booking was extended
			    assertEquals("5", extend.duration);
				
	}

}

