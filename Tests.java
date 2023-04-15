import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Vector;

import org.junit.Test;
import tester.*;
import tester.System;

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
		
		s.newName();
		s.pwd();
		
		//view auto account test
		viewAutoAccount v = new viewAutoAccount();
		//number of rows(at the time of this running there should only be 7, 6 in clients.txt and one made prior)
		int numberRows = v.numberRows();
		assertNotEquals(7,numberRows);
		
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
		String[] test11111 = {"6fbl67p19h"," null"," null"," null"," wKr9J^y%7B","Manager","-1"};
		assertEquals(row[0],test11111[0]);
		assertEquals(row[1],test11111[1]);
		assertEquals(row[2],test11111[2]);
		assertEquals(row[3],test11111[3]);
		assertEquals(row[4],test11111[4]);
		assertEquals(row[5],test11111[5]);
		
		row = v.getAutoAccount(4);
		String[] test1111111 = {"test_user1","null","null","null","test_pass1","Manager","-1"};
		assertEquals(row[0],test1111111[0]);
		assertEquals(row[1],test1111111[1]);
		assertEquals(row[2],test1111111[2]);
		assertEquals(row[3],test1111111[3]);
		assertEquals(row[4],test1111111[4]);
		assertEquals(row[5],test1111111[5]);
		
		
	}
	
	@Test
	public void test3(){
				
				//edit booking
				EditBooking edit = new EditBooking();
				edit.username = "HappyBuddy77";
				edit.lp = "123ABC";
				edit.pl = "A";
				edit.ps = "2";
				edit.date = "13/04/2023";
				edit.time = "14";
				edit.duration = "3";
			
				ArrayList<Integer> tester2 = new ArrayList<Integer>();
				tester2.add(10);
				tester2.add(13);
				tester2.add(17);
				tester2.add(20);
				tester2.add(21);
				tester2.add(22);
				
				ArrayList<Integer> test = new ArrayList<Integer>();
				test = edit.edit("5 Hours", "18:00 EST", "13/04/2024", false);
				assertEquals(test, tester2);
				
				ExtendBooking extend = new ExtendBooking();
				extend.setLP("L2CP02");
				extend.setPL("A");
			    extend.setPS("2");
			    extend.setDate("13/04/2023");
			    extend.setTime("14");
			    extend.setDuration("5");
			    
			    test = extend.extend("5 Hours", false);
				assertEquals(test, tester2);
			       
			    // Extend booking from 3 to 5 hours
				manageParkingLot m = new manageParkingLot();
				PayBooking p = new PayBooking();
				p.setUsername("HappyBuddy77");
				p.setType("Student");
				p.setAmountDue(10);
				p.pay("HappyBuddy77", 10, false);
				
				
	}
	
	@Test
	public void test4() {
		// System
//		System s = System.getInstance();
//		boolean bool = s.equals(null);
//		assertEquals(false, bool);

		Manager k = new Manager();
		validateAccounts v = new validateAccounts();
		
		//Read validateClients.txt and save dimensions of data in text file
		Vector<Vector> ValidatingClients = validateAccounts.readValidateClients();
		int valRows = ValidatingClients.size();
		int valColumns = ValidatingClients.get(0).size();

		//Read Clients.txt and save dimensions of the data in the text file
		Vector<Vector> Clients = validateAccounts.readClients();
		int clientRows = Clients.size();
		int clientColumns = Clients.get(0).size(); 
		//Assert Not Empty and has 7 columns
		assertTrue(clientRows > 0);
		assertEquals(7 , clientColumns);

		// Rows that are 'selected'. 
		Vector a = ValidatingClients.get(0);
		Vector b = ValidatingClients.get(1);
		Vector c = ValidatingClients.get(2);

		// Removing 'selected' Rows
		validateAccounts.declineClient(a, ValidatingClients);
		validateAccounts.declineClient(b, ValidatingClients);
		validateAccounts.declineClient(c, ValidatingClients);

		Vector<Vector> ValidatingClients2 = validateAccounts.readValidateClients();

		// Asserts for ValidatingClients
		assertTrue(ValidatingClients2.size() == valRows -3);
		assertTrue(ValidatingClients2.get(0).size() == valColumns);
		assertFalse(ValidatingClients2.isEmpty());

		assertFalse(ValidatingClients2.contains(a));
		assertFalse(ValidatingClients2.contains(b));
		assertFalse(ValidatingClients2.contains(c));	

		Vector<Vector> Clients2 = validateAccounts.readClients();
		// Asserts for Clients
		assertTrue(Clients.size() == Clients2.size());
		assertTrue(Clients.equals(Clients2));




		//save dimensions of ValidatingClients2 
		valRows = ValidatingClients2.size();
		valColumns = ValidatingClients2.get(0).size();

		//Assert Clients is Not Empty and has 7 columns
		assertTrue(clientRows > 0);
		assertEquals(7 , clientColumns);

		// Rows that are 'selected'. 
		Vector d = ValidatingClients2.get(0);
		b = ValidatingClients2.get(1);
		c = ValidatingClients2.get(2);

		// Accept 'selected' Rows
		validateAccounts.acceptClient(d, ValidatingClients2);
		validateAccounts.acceptClient(b, ValidatingClients2);
		validateAccounts.acceptClient(c, ValidatingClients2);

		Vector<Vector> ValidatingClients3 = validateAccounts.readValidateClients();

		// Asserts for ValidatingClients
		assertTrue(ValidatingClients3.size() == valRows -3);
		assertTrue(ValidatingClients3.get(0).size() == valColumns);
		assertFalse(ValidatingClients3.isEmpty());

		assertFalse(ValidatingClients3.contains(d));
		assertFalse(ValidatingClients3.contains(b));
		assertFalse(ValidatingClients3.contains(c));	

		Vector<Vector> Clients3 = validateAccounts.readClients();
		
		
		// Asserts for Clients
		assertTrue(Clients3.size() == Clients2.size() + 3);
		assertFalse(Clients2.equals(Clients3));

//		assertTrue(Clients3.contains(d));
//		assertTrue(Clients3.contains(b));
//		assertTrue(Clients3.contains(c));	

		String[] parkingLots = ReadCSV.allParkingLots();
		
		assertTrue(parkingLots.length != 0);
		
		boolean isPresent = false;

		for (String element : parkingLots) {
		    if (element.equals("Parking Lot X") || element.equals("Parking Lot Y") || element.equals("Parking Lot Z")) {
		        isPresent = true;
		        break;
		    }
		}
		
		assertFalse(isPresent);
		
		manageParkingLot.addParkingLot("Parking Lot X");
		manageParkingLot.addParkingLot("Parking Lot Y");
		manageParkingLot.addParkingLot("Parking Lot Z");
		
		String[] parkingLots2 = ReadCSV.allParkingLots();

		boolean isPresentX = false;
		boolean isPresentY = false;
		boolean isPresentZ = false;
		for (String element : parkingLots2) {
			//JOptionPane.showMessageDialog(null,element);
		    if (element.equals("Parking Lot X")) {
				//JOptionPane.showMessageDialog(null,element);
		        isPresentX = true;
		    }
		    else if (element.equals("Parking Lot Y")) {
		        isPresentY = true;
		    }
		    else if (element.equals("Parking Lot Z")) {
		        isPresentZ = true;
		    }
		}
		
		assertTrue(isPresentX);
		assertTrue(isPresentY);
		assertTrue(isPresentZ);

		LandingPageManager m = new LandingPageManager();
		manageParkingLot p = new manageParkingLot();

		String[] lots3 = ReadCSV.allParking();
		isPresent = false;
		for (String element : lots3) {
			if(element.equals("Parking Lot A,0")) {
				isPresent = true;
			}
		}
		assertTrue(isPresent);
		
		p.disableParkingLot("Parking Lot A");
		
		String[] lots4 = ReadCSV.allParking();
		
		isPresent = false;
		for (String element : lots4) {
			if(element.equals("Parking Lot A,0")) {
				isPresent = true;
				break;
			}
		}
		assertFalse(isPresent);
		
		isPresent = false;
		for (String element : lots4) {
		    if (element.equals("Parking Lot A,-1")) {
		        isPresent = true;
		    }
		}
		assertTrue(isPresent);
		
		
		String[] lots = ReadCSV.allParking();
		isPresent = false;
		for (String element : lots) {
			if(element.equals("Parking Lot A,-1")) {
				isPresent = true;
			}
		}
		assertTrue(isPresent);
		
		p.enableParkingLot("Parking Lot A");
		
		String[] lots2 = ReadCSV.allParking();
		
		isPresent = false;
		for (String element : lots2) {
			if(element.equals("Parking Lot A,-1")) {
				isPresent = true;
				break;
			}
		}
		assertFalse(isPresent);
		
		isPresent = false;
		for (String element : lots2) {
		    if (element.equals("Parking Lot A,0")) {
		        isPresent = true;
		    }
		}
		assertTrue(isPresent);
		
		
		editParkingSpace parkingSpace = p.editParking("Parking Lot A");
		parkingSpace.fillTable();
	}	

}
