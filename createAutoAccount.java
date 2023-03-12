
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class createAutoAccount {
    JFrame frame = new JFrame();
    JTextField txt_username = new JTextField();
    JTextField txt_password = new JTextField();
    JLabel lblNewLabel = new JLabel("");
    JButton btnNewButton = new JButton("Enter");

    public createAutoAccount() {
        
        frame = new JFrame();
		frame.setBounds(100, 100, 451, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt_username = new JTextField();
		txt_username.setEditable(false);
		txt_username.setBounds(135, 72, 165, 19);
		frame.getContentPane().add(txt_username);
		
		txt_password = new JTextField();
		txt_password.setEditable(false);
		txt_password.setBounds(135, 102, 165, 19);
		frame.getContentPane().add(txt_password);
		
		JButton btn_create_account = new JButton("Create Account");
		btn_create_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//method called from System class that generates and returns
				String userName = "userID generated from System";
				String password = "password generated from System";
				txt_username.setText(userName);
				txt_password.setText(password);
			}
		});
		
		JButton btn_return = new JButton("Return");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				superManagerMainPage a2 = new superManagerMainPage();
				a2.frame.setVisible(true);
			}
		});
		
		
		btn_create_account.setBounds(140, 132, 149, 21);
		frame.getContentPane().add(btn_create_account);
		
		JLabel lbl_password = new JLabel("Password:");
		lbl_password.setBounds(73, 102, 83, 21);
		frame.getContentPane().add(lbl_password);
		
		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setBounds(73, 72, 83, 21);
		frame.getContentPane().add(lbl_username);
		
		JLabel lbl_title = new JLabel("Generate Auto Account");
		lbl_title.setBounds(95, 31, 254, 30);
		frame.getContentPane().add(lbl_title);
		
		btn_return.setBounds(10, 228, 89, 23);
		frame.getContentPane().add(btn_return);
		
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
        createAutoAccount s = new createAutoAccount();
        s.frame.setVisible(true);
    }
}