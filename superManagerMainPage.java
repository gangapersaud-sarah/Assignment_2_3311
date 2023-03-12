
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class superManagerMainPage {
    JFrame frame = new JFrame();
    JTextField txt_username = new JTextField();
    JTextField txt_password = new JTextField();
    JLabel lblNewLabel = new JLabel("");
    JButton btnNewButton = new JButton("Enter");

    public superManagerMainPage() {
        
        frame = new JFrame();
		frame.setBounds(100, 100, 451, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_create_auto = new JButton("Create Auto Account");
		btn_create_auto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//method called from System class that generates and returns
				frame.setVisible(false);
				createAutoAccount a2 = new createAutoAccount();
				a2.frame.setVisible(true);
				
			}
		});
		
		JButton btn_view_auto1 = new JButton("View auto accounts");
		btn_view_auto1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//method called from System class that generates and returns
				frame.setVisible(false);
				viewAutoAccount b2 = new viewAutoAccount();
				b2.frame.setVisible(true);
				
			}
		});
		
		JButton btn_return = new JButton("return");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//method called from System class that generates and returns
				frame.setVisible(false);
				manager_medium c2 = new manager_medium();
				c2.frame.setVisible(true);
				
			}
		});
		
		btn_create_auto.setBounds(34, 108, 149, 21);
		frame.getContentPane().add(btn_create_auto);
		
		btn_view_auto1.setBounds(246, 107, 149, 22);
		frame.getContentPane().add(btn_view_auto1);
		
		btn_return.setBounds(10, 228, 89, 23);
		frame.getContentPane().add(btn_return);
		
		JLabel lbl_title = new JLabel("Super Manager Main Page");
		lbl_title.setBounds(144, 11, 214, 30);
		frame.getContentPane().add(lbl_title);
		
		
		
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
        superManagerMainPage s = new superManagerMainPage();
        s.frame.setVisible(true);
    }
}