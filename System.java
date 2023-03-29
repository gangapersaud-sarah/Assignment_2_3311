import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class System {

	private static System instance = null;
    public static Object out;
    JFrame frame = new JFrame();
    JTextField txt_username = new JTextField();
    JTextField txt_password = new JTextField();
    JLabel lblNewLabel = new JLabel("");
    JButton btnNewButton = new JButton("Enter");
	public static String loggedInUserName;
    public static String loggedInAccountType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System window = new System();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
				doSignin();
			}
		});
		frame.getContentPane().add(btn_SignUp);
		
		JButton btn_LogIn = new JButton("Log In");
		btn_LogIn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_LogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin(txt_username.getText(), txt_password.getText());
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
	
	public void doSignin() {
		Sign_in newFrame = new Sign_in();
		newFrame.setVisible(true);
		frame.setVisible(false);
	}
	
	public void doLogin(String user, String pwd) {
		String userName = user;
		String password = pwd;
		ArrayList<String> returnList = new ArrayList<String>();
		returnList = ReadCSV.findUserName(userName, "Clients.txt");
		
		SystemFacade s = new SystemFacade(frame, returnList, password);
		if(returnList.get(4).equals(password)) {
			if(returnList.get(5).equals("Student") || returnList.get(5).equals("Faculty") || returnList.get(5).equals("Staff") || returnList.get(5).equals("Visitor")) {
				s.viewClientWindow();
				loggedInUserName = userName;
				loggedInAccountType = returnList.get(5);
			}
			else if(returnList.get(5).equals("Manager")) {
				s.viewManagerWindow();
			}
			else if(returnList.get(5).equals("Super-Manager")) {
				s.viewSuperWindow();
			}
		}
	}
	
	public static System getInstance(){
		if (instance == null){
			instance = new System();
		}
		return instance;
	}
}
