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
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(33, 171, 154, 48);
		contentPane.add(label);
		
		Label label_1 = new Label("Date:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(33, 261, 130, 48);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Time:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(400, 171, 140, 48);
		contentPane.add(label_2);
		
		Label label_2_1 = new Label("Duration:");
		label_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2_1.setBounds(400, 261, 140, 48);
		contentPane.add(label_2_1);
		
		JTextField txt_lp = new JTextField();
		txt_lp.setBounds(193, 171, 178, 48);
		contentPane.add(txt_lp);
		txt_lp.setColumns(10);
		
		JButton btn_Add = new JButton("Add Booking");
		btn_Add.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_Add.setBounds(257, 449, 257, 88);
		contentPane.add(btn_Add);
		
		JComboBox cmb_time = new JComboBox();
		cmb_time.setBounds(577, 171, 178, 48);
		contentPane.add(cmb_time);
		
		JComboBox cmb_duration = new JComboBox();
		cmb_duration.setBounds(577, 261, 178, 48);
		contentPane.add(cmb_duration);
		
		JTextField txt_date = new JTextField();
		txt_date.setBounds(193, 261, 178, 48);
		contentPane.add(txt_date);
		txt_date.setColumns(10);
		
		JComboBox cmb_pl = new JComboBox();
		cmb_pl.setBounds(193, 349, 178, 48);
		contentPane.add(cmb_pl);
		
		Label label_2_2 = new Label("Parking Lot:");
		label_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2_2.setBounds(33, 349, 140, 48);
		contentPane.add(label_2_2);
		
		JComboBox cmb_ps = new JComboBox();
		cmb_ps.setBounds(577, 349, 178, 48);
		contentPane.add(cmb_ps);
		
		Label label_2_3 = new Label("Parking \r\nSpace:");
		label_2_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2_3.setBounds(400, 349, 154, 48);
		contentPane.add(label_2_3);
	}
}
