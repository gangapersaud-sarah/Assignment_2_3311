public class UserFactory{
	
	// This could be used as a static method if we
	// are willing to give up subclassing it
	
	public static void newUser(String username, String first,String last,String email,String pwd,String type, int due){
		if (type.equals("Student")){	
			WriteCSV.ClientValid(username, first, last, email, pwd, type, due);
		} 
		else if (type.equals("Faculty")){
			WriteCSV.ClientValid(username, first, last, email, pwd, type, due);
		} 
		else if (type.equals("Staff")){
			WriteCSV.ClientValid(username, first, last, email, pwd, type, due);
		} 
		else {
			WriteCSV.saveClient(username, first, last, email, pwd, type, due);
		}
	}
	
}

