import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class Sign_in extends JFrame{

    private JPanel contentPane;
	private JTextField txt_firstName;
	private JTextField txt_lastName;
	private JTextField txt_email;
	private JPasswordField pwf_password;

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
		cmb_userType.setBounds(329, 397, 300, 40);
		contentPane.add(cmb_userType);
		cmb_userType.addItem("Student");
		cmb_userType.addItem("Faculty");
		cmb_userType.addItem("Non-Faculty");
		cmb_userType.addItem("Visitor");
		
		JLabel lbl_type = new JLabel("User Type:");
		lbl_type.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_type.setBounds(119, 393, 200, 40);
		contentPane.add(lbl_type);
		
		JButton btn_register = new JButton("Register");
		btn_register.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_register.setBounds(300, 486, 200, 50);
		contentPane.add(btn_register);
		
		pwf_password = new JPasswordField();
		pwf_password.setBounds(329, 321, 300, 40);
		contentPane.add(pwf_password);
    }
}
