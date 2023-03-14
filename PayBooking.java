import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PayBooking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayBooking frame = new PayBooking();
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
	public PayBooking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pay Booking");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 56));
		lblNewLabel.setBounds(0, 0, 786, 124);
		contentPane.add(lblNewLabel);
		
		
		Label label = new Label("Total:");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(52, 130, 216, 48);
		contentPane.add(label);
		
		Label label_1 = new Label("Select Method of Payment:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(52, 199, 445, 48);
		contentPane.add(label_1);
				
		JButton btnNewButton = new JButton("Credit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(257, 264, 257, 88);
		contentPane.add(btnNewButton);
		
		JButton btnDebt = new JButton("Debit");
		btnDebt.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnDebt.setBounds(257, 363, 257, 88);
		contentPane.add(btnDebt);
		
		JButton btnOther = new JButton("Other");
		btnOther.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnOther.setBounds(257, 462, 257, 88);
		contentPane.add(btnOther);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(207, 135, 49, 14);
		contentPane.add(label_2);
		
		Label label_3 = new Label("$");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(298, 130, 216, 48);
		contentPane.add(label_3);
	}

}
