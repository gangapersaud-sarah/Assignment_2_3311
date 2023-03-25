import java.util.ArrayList;
import javax.swing.JFrame;

//The Facade Design Pattern decouples or separates the client 
//from all of the sub components

//The Facades aim is to simplify interfaces so you don't have 
//to worry about what is going on under the hood

public class SystemFacade {
	String username;
	ArrayList<String> list;
	JFrame f;
	
	public SystemFacade(JFrame f, ArrayList<String> list, String username){
		this.f = f;
		this.username = username;
		this.list = list;
	}
	public void viewClientWindow(){
		ClientWindow newFrame = new ClientWindow();
		newFrame.setUsername(username);
		newFrame.setType(list.get(5));
		String[] parts = list.get(6).split("\r");
		newFrame.setAmountDue(Integer.valueOf(parts[0]));
		newFrame.setVisible(true);
		f.setVisible(false);
	}
	
	
	public void viewManagerWindow(){
		Manager newFrame = new Manager();
		newFrame.setVisible(true);
		f.setVisible(false);
	}
	
	public void viewSuperWindow(){
		manager_medium newFrame = new manager_medium();
		newFrame.frame.setVisible(true);
		f.setVisible(false);
	}
	
}

