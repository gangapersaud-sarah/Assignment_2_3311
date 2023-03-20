import java.util.ArrayList;

public interface Authenticate {
	boolean operation(String myPass);
}

// each class is a different type of strategy (operation)
class authUsername implements Authenticate {
	public boolean operation(String myPass) {
		ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>();
		returnList = ReadCSV.allUsers("Clients.txt");
		boolean found = false;
		for (int i = 0; i < returnList.size(); i++) {
			String compare = returnList.get(i).get(0);
                if(compare.equals(myPass)) {	
                	found = true;
                }  
        }
		return found;
	} 
}

class authEmail implements Authenticate {
	public boolean operation(String myPass) {
		ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>();
		returnList = ReadCSV.allUsers("Clients.txt");
		boolean found = false;
		for (int i = 0; i < returnList.size(); i++) {
			String compare = returnList.get(i).get(3);
                if(compare.equals(myPass)) {	
                	found = true;
                }  
        }
		return found;
	}   
}

