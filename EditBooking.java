package src;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditBooking {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditBooking window = new EditBooking();
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
	public EditBooking() {
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
		
		JLabel lblNewLabel = new JLabel("Edit Booking");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 56));
		lblNewLabel.setBounds(0, 0, 786, 124);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Update Booking");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(239, 464, 293, 88);
		frame.getContentPane().add(btnNewButton);
		
		Label label = new Label("License Plate:");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(52, 178, 216, 48);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Date:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(52, 247, 199, 48);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Time:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(52, 316, 199, 48);
		frame.getContentPane().add(label_2);
		
		Label label_2_1 = new Label("Duration:");
		label_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2_1.setBounds(52, 391, 199, 48);
		frame.getContentPane().add(label_2_1);
		
		textField = new JTextField();
		textField.setBounds(334, 178, 316, 48);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(334, 316, 316, 48);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(334, 391, 316, 48);
		frame.getContentPane().add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(334, 247, 316, 48);
		frame.getContentPane().add(textField_1);
		
		textField = new JTextField();
		textField.setBounds(334, 206, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(334, 247, 316, 48);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
	}

}
