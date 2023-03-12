

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class PayBooking {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayBooking window = new PayBooking();
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
	public PayBooking() {
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
		
		JLabel lblNewLabel = new JLabel("Pay Booking");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 56));
		lblNewLabel.setBounds(0, 0, 786, 124);
		frame.getContentPane().add(lblNewLabel);
		
		
		Label label = new Label("Total:");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(52, 130, 216, 48);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Select Method of Payment:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(52, 199, 445, 48);
		frame.getContentPane().add(label_1);
				
		JButton btnNewButton = new JButton("Credit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(257, 264, 257, 88);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDebt = new JButton("Debit");
		btnDebt.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnDebt.setBounds(257, 363, 257, 88);
		frame.getContentPane().add(btnDebt);
		
		JButton btnOther = new JButton("Other");
		btnOther.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnOther.setBounds(257, 462, 257, 88);
		frame.getContentPane().add(btnOther);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(207, 135, 49, 14);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("$");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(298, 130, 216, 48);
		frame.getContentPane().add(label_3);
		
		
		
//		textField_1 = new JTextField();
//		textField_1.setBounds(334, 247, 316, 48);
//		frame.getContentPane().add(textField_1);
//		textField_1.setColumns(10);
	}
}
