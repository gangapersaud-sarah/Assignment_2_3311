import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sign_in extends JFrame {

	private JPanel contentPane;
	private JTextField txt_firstName;
	private JTextField txt_lastName;
	private JTextField txt_email;
	private JPasswordField pwf_password;
	private JTextField txt_username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_in frame = new Sign_in();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sign_in() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_first = new JLabel("First Name:");
		lbl_first.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_first.setBounds(119, 85, 200, 40);
		contentPane.add(lbl_first);
		
		JLabel lbl_last = new JLabel("Last Name:");
		lbl_last.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_last.setBounds(119, 152, 200, 40);
		contentPane.add(lbl_last);
		
		txt_firstName = new JTextField();
		txt_firstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_firstName.setBounds(329, 90, 300, 40);
		contentPane.add(txt_firstName);
		
		txt_lastName = new JTextField();
		txt_lastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_lastName.setBounds(329, 152, 300, 40);
		contentPane.add(txt_lastName);
		
		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_email.setBounds(119, 260, 200, 40);
		contentPane.add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_email.setBounds(329, 260, 300, 40);
		contentPane.add(txt_email);
		
		JLabel lbl_password = new JLabel("Password:");
		lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_password.setBounds(119, 321, 200, 40);
		contentPane.add(lbl_password);
		
		JComboBox cmb_userType = new JComboBox();
		cmb_userType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_userType.setBounds(329, 375, 300, 40);
		contentPane.add(cmb_userType);
		cmb_userType.addItem("Student");
		cmb_userType.addItem("Faculty");
		cmb_userType.addItem("Non-Faculty");
		cmb_userType.addItem("Visitor");
		
		JLabel lbl_type = new JLabel("User Type:");
		lbl_type.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_type.setBounds(119, 371, 200, 40);
		contentPane.add(lbl_type);
		
		pwf_password = new JPasswordField();
		pwf_password.setBounds(329, 321, 300, 40);
		contentPane.add(pwf_password);
		
		JLabel lbl_email_1 = new JLabel("Username:");
		lbl_email_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_email_1.setBounds(119, 210, 200, 40);
		contentPane.add(lbl_email_1);
		
		txt_username = new JTextField();
		txt_username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_username.setBounds(329, 210, 300, 40);
		contentPane.add(txt_username);
		
		JLabel lbl_response = new JLabel("");
		lbl_response.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_response.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_response.setBounds(119, 447, 510, 46);
		contentPane.add(lbl_response);
		
		JButton btn_register = new JButton("Register");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txt_username.getText();
				String email = txt_email.getText();
				String first = txt_firstName.getText();
				String last = txt_lastName.getText();
				String pwd = String.valueOf(pwf_password.getPassword());
				String type = (String) cmb_userType.getSelectedItem();
				
				Validate v = new Validate();
				
				v.ChangeStrat(new authUsername());
				boolean isUsername = v.DoOp(username);
				
				v.ChangeStrat(new authEmail());
				boolean isEmail = v.DoOp(email);
				
				if(isUsername) {
					lbl_response.setText(username + " has been taken please choose another name");
				}
				else if(isEmail) {
					lbl_response.setText(email + " has been taken please choose another email");
				}
				else {
					lbl_response.setText(pwd + " is invalid please choose another password");
					
					if(pwd.matches("(.*)[0-9](.*)") && pwd.matches("(.*)[a-z](.*)") 
							&& pwd.matches("(.*)[!@#$&()\\-`.+,/\"](.*)") && pwd.matches("(.*)[A-Z](.*)")) {
						WriteCSV.saveClient(username, first, last, email, pwd, type);
					}
					else if(!(pwd.matches("(.*)[a-z](.*)"))) {
						lbl_response.setText("must include lowercase letter");
					}
					else if(!(pwd.matches("(.*)[!@#$&()\\-`.+,/\"](.*)"))) {
						lbl_response.setText("must include special charcter");
					}
					else if(!(pwd.matches("(.*)[A-Z](.*)"))) {
						lbl_response.setText("must include uppercase letter");
					}
					else if(!(pwd.matches("(.*)[0-9](.*)"))) {
						lbl_response.setText("must include number");
					}
					else {
						lbl_response.setText(pwd + " is invalid please choose another password");
					}
				}
			}
		});
		btn_register.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_register.setBounds(302, 503, 200, 50);
		contentPane.add(btn_register);
		
		
	}
}
