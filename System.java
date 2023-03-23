import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class System {
    public static Object out;
    JFrame frame = new JFrame();
    JTextField txt_username = new JTextField();
    JTextField txt_password = new JTextField();
    JLabel lblNewLabel = new JLabel("");
    JButton btnNewButton = new JButton("Enter");
	public static String loggedInUserName;
    public static String loggedInAccountType;


    public System() {
        
        frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt_username = new JTextField();
		txt_username.setBounds(321, 141, 410, 50);
		frame.getContentPane().add(txt_username);
		
		txt_password = new JTextField();
		txt_password.setBounds(321, 281, 410, 50);
		frame.getContentPane().add(txt_password);
		
		JButton btn_SignUp = new JButton("Sign Up");
		btn_SignUp.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_SignUp.setBounds(97, 415, 250, 70);
		btn_SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sign_in newFrame = new Sign_in();
				newFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btn_SignUp);
		
		JButton btn_LogIn = new JButton("Log In");
		btn_LogIn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_LogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = txt_username.getText();
				String password = txt_password.getText();
				ArrayList<String> returnList = new ArrayList<String>();
				returnList = ReadCSV.findUserName(userName, "Clients.txt");
				if(returnList.get(4).equals(password)) {
					if(returnList.get(5).equals("Student") || returnList.get(5).equals("Faculty") || returnList.get(5).equals("non-Faculty") || returnList.get(5).equals("Visitor")) {
						ClientWindow newFrame = new ClientWindow();
						newFrame.setUsername(userName);
						newFrame.setType(returnList.get(5));
						newFrame.setAmountDue(Integer.valueOf(returnList.get(6)));
						
						loggedInUserName = userName;
						loggedInAccountType = returnList.get(5);
						
						newFrame.setVisible(true);
						frame.setVisible(false);
					}
					else if(returnList.get(5).equals("Manager")) {
						Manager newFrame = new Manager();
						newFrame.setVisible(true);
						frame.setVisible(false);
					}
					else if(returnList.get(5).equals("Super-Manager")) {
						superManagerMainPage newFrame = new superManagerMainPage();
						newFrame.setVisible(true);
						frame.setVisible(false);
					}
				}
			}
		});
		btn_LogIn.setBounds(421, 415, 250, 70);
		frame.getContentPane().add(btn_LogIn);
		
		JLabel lbl_password = new JLabel("Password:");
		lbl_password.setBounds(43, 238, 251, 131);
		lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 50));
		frame.getContentPane().add(lbl_password);
		
		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setBounds(43, 125, 246, 66);
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 50));
		frame.getContentPane().add(lbl_username);
    }

	// Can we have a validate-User-Type? Since a manager can add valid user types 
    // validate user email when user signs up
    public boolean authenticateEmail() {
        return true;
    }

    // validate user password when user signs up
    public boolean authenticatePassword() {
        return true;
    }

    public static void main(String args[]) {
        System s = new System();
        s.frame.setVisible(true);
    }
}


