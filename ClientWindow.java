import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTextField;

public class ClientWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientWindow window = new ClientWindow();
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
	public ClientWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_View = new JButton("View Booking");
		btn_View.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_View.setBackground(new Color(192, 192, 192));
		btn_View.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Bookings newFrame = new View_Bookings();
				newFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btn_View.setBounds(281, 240, 262, 82);
		frame.getContentPane().add(btn_View);
		
		JButton btn_Pay = new JButton("Pay Booking");
		btn_Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayBooking newFrame = new PayBooking();
				newFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btn_Pay.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_Pay.setBackground(new Color(192, 192, 192));
		btn_Pay.setBounds(281, 426, 262, 82);
		frame.getContentPane().add(btn_Pay);
		
		JButton btn_Add = new JButton("Add Booking");
		btn_Add.setBackground(new Color(192, 192, 192));
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBooking newFrame = new AddBooking();
				newFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btn_Add.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_Add.setBounds(281, 333, 262, 82);
		frame.getContentPane().add(btn_Add);
		
		JLabel lblNewLabel = new JLabel("Welcome, Client!");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 56));
		lblNewLabel.setBounds(0, 0, 786, 124);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please Select an Option Below");
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(53, 135, 693, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(192, 192, 192));
		textField.setBounds(0, 0, 786, 209);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		

	}
}
