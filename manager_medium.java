import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class manager_medium {
    JFrame frame = new JFrame();
    JTextField txt_username = new JTextField();
    JTextField txt_password = new JTextField();
    JLabel lblNewLabel = new JLabel("");
    JButton btnNewButton = new JButton("Enter");

    public manager_medium() {
        
        frame = new JFrame();
		frame.setBounds(100, 100, 451, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_goto_supermanager = new JButton("SuperManager");
		btn_goto_supermanager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				superManagerMainPage a2 = new superManagerMainPage();
				a2.setVisible(true);
			}
		});
		
		JButton btn_goto_manager = new JButton("Manager");
		btn_goto_manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				LandingPageManager b2 = new LandingPageManager();
				b2.setVisible(true);
			}
		});
		
		btn_goto_supermanager.setBounds(20, 101, 153, 23);
		frame.getContentPane().add(btn_goto_supermanager);
		
		btn_goto_manager.setBounds(293, 101, 89, 23);
		frame.getContentPane().add(btn_goto_manager);
		
		JLabel lbl_title = new JLabel("choose management page:");
		lbl_title.setBounds(151, 38, 254, 30);
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
        manager_medium s = new manager_medium();
        s.frame.setVisible(true);
    }
}