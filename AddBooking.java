import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AddBooking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooking frame = new AddBooking();
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
	public AddBooking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Booking");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 56));
		lblNewLabel.setBounds(0, 0, 786, 124);
		contentPane.add(lblNewLabel);
		
		
		Label label = new Label("License Plate:");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(52, 178, 216, 48);
		contentPane.add(label);
		
		Label label_1 = new Label("Date:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(52, 247, 199, 48);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Time:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(52, 316, 199, 48);
		contentPane.add(label_2);
		
		Label label_2_1 = new Label("Duration:");
		label_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2_1.setBounds(52, 391, 199, 48);
		contentPane.add(label_2_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(334, 178, 316, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Booking");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(260, 450, 257, 88);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(334, 316, 316, 48);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(334, 391, 316, 48);
		contentPane.add(comboBox_1);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(334, 247, 316, 48);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

}
