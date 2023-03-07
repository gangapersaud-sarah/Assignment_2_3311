import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class System {
    JFrame frame = new JFrame();
    JTextField txt_username = new JTextField();
    JTextField txt_password = new JTextField();
    JLabel lblNewLabel = new JLabel("");
    JButton btnNewButton = new JButton("Enter");

    public System() {
        
        frame = new JFrame();
		frame.setBounds(100, 100, 451, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt_username = new JTextField();
		txt_username.setBounds(175, 29, 165, 19);
		frame.getContentPane().add(txt_username);
		
		txt_password = new JTextField();
		txt_password.setBounds(175, 79, 165, 19);
		frame.getContentPane().add(txt_password);
		
		JLabel lbl_response = new JLabel("");
		lbl_response.setBounds(139, 164, 165, 42);
		frame.getContentPane().add(lbl_response);
		
		JButton btn_SignUp = new JButton("Sign Up");
		btn_SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = txt_username.getText();
				String password = txt_password.getText();
				lbl_response.setText(userName + " " + password);
			}
		});
		btn_SignUp.setBounds(119, 118, 85, 21);
		frame.getContentPane().add(btn_SignUp);
		
		JButton btn_LogIn = new JButton("Log In");
		btn_LogIn.setBounds(239, 118, 85, 21);
		frame.getContentPane().add(btn_LogIn);
		
		JLabel lbl_password = new JLabel("Password:");
		lbl_password.setBounds(73, 75, 83, 21);
		frame.getContentPane().add(lbl_password);
		
		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setBounds(73, 25, 83, 21);
		frame.getContentPane().add(lbl_username);
		
    }


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


