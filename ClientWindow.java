import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ClientWindow extends JFrame {

	private JPanel contentPane;
	public String username = "";
	public String type = "";
	public int amountDue = -1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientWindow frame = new ClientWindow();
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
	public ClientWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.WHITE);

		setContentPane(contentPane);
		
		JButton btn_View = new JButton("View Booking");
		btn_View.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_View.setBackground(new Color(192, 192, 192));
		btn_View.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Bookings newFrame = new View_Bookings();
				newFrame.setUsername(username);
				newFrame.setType(type);
				newFrame.setAmountDue(amountDue);
				newFrame.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Please Select an Option Below");
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(169, 119, 462, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome, Client!");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 56));
		lblNewLabel.setBounds(154, 41, 477, 68);
		contentPane.add(lblNewLabel);
		btn_View.setBounds(72, 243, 250, 100);
		contentPane.add(btn_View);
		
		JButton btn_Pay = new JButton("Pay Booking");
		btn_Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayBooking newFrame = new PayBooking();
				newFrame.setUsername(username);
				newFrame.setType(type);
				newFrame.setAmountDue(amountDue);
				newFrame.setVisible(true);
				setVisible(false);
			}
		});
		btn_Pay.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_Pay.setBackground(new Color(192, 192, 192));
		btn_Pay.setBounds(72, 387, 250, 100);
		contentPane.add(btn_Pay);
		
		JButton btn_Add = new JButton("Add Booking");
		btn_Add.setBackground(new Color(192, 192, 192));
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBooking newFrame = new AddBooking();
				newFrame.setUsername(username);
				newFrame.setType(type);
				newFrame.setAmountDue(amountDue);
				newFrame.setVisible(true);
				setVisible(false);
			}
		});
		btn_Add.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_Add.setBounds(430, 243, 250, 100);
		contentPane.add(btn_Add);
		
		JButton btn_LogOut = new JButton("Log Out");
		btn_LogOut.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_LogOut.setBackground(Color.LIGHT_GRAY);
		btn_LogOut.setBounds(430, 387, 250, 100);
		contentPane.add(btn_LogOut);
		
	}
	
	public void setUsername(String s) {
		username = s;
	}
	public void setType(String s) {
		type = s;
	}
	public void setAmountDue(int s) {
		amountDue = s;
	}

}
