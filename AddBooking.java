import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JComboBox cmb_time = new JComboBox();
		cmb_time.setBounds(577, 171, 178, 48);
		contentPane.add(cmb_time);
		cmb_time.addItem("0:00 EST");
		cmb_time.addItem("1:00 EST");
		cmb_time.addItem("2:00 EST");
		cmb_time.addItem("3:00 EST");
		cmb_time.addItem("4:00 EST");
		cmb_time.addItem("5:00 EST");
		cmb_time.addItem("6:00 EST");
		cmb_time.addItem("7:00 EST");
		cmb_time.addItem("8:00 EST");
		cmb_time.addItem("9:00 EST");
		cmb_time.addItem("10:00 EST");
		cmb_time.addItem("11:00 EST");
		cmb_time.addItem("12:00 EST");
		cmb_time.addItem("13:00 EST");
		cmb_time.addItem("14:00 EST");
		cmb_time.addItem("15:00 EST");
		cmb_time.addItem("16:00 EST");
		cmb_time.addItem("17:00 EST");
		cmb_time.addItem("18:00 EST");
		cmb_time.addItem("19:00 EST");
		cmb_time.addItem("20:00 EST");
		cmb_time.addItem("21:00 EST");
		cmb_time.addItem("22:00 EST");
		cmb_time.addItem("23:00 EST");
		
		JComboBox cmb_duration = new JComboBox();
		cmb_duration.setBounds(577, 261, 178, 48);
		contentPane.add(cmb_duration);
		cmb_duration.addItem("1 Hour");
		cmb_duration.addItem("2 Hours");
		cmb_duration.addItem("3 Hours");
		cmb_duration.addItem("4 Hours");
		cmb_duration.addItem("5 Hours");
		cmb_duration.addItem("6 Hours");
		
		JTextField txt_date = new JTextField();
		txt_date.setBounds(193, 261, 178, 48);
		contentPane.add(txt_date);
		
		JComboBox cmb_pl = new JComboBox();
		cmb_pl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cmb_pl.setBounds(193, 349, 178, 48);
		contentPane.add(cmb_pl);
		String[] allPL = ReadCSV.allParkingLots();
		ReadCSV.allParkingLots();
		for(int i = 0; i < allPL.length; i++) {
			cmb_pl.addItem((String)allPL[i]);
		}
		
		Label label_2_2 = new Label("Parking Lot:");
		label_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2_2.setBounds(33, 349, 140, 48);
		contentPane.add(label_2_2);
		
		JComboBox cmb_ps = new JComboBox();
		cmb_ps.setBounds(577, 349, 178, 48);
		contentPane.add(cmb_ps);
		String[] allPS = ReadCSV.allParkingSpaces();
		for(int i = 0; i < allPS.length; i++) {
			cmb_ps.addItem((String)allPS[i]);
		}
		
		Label label_2_3 = new Label("Parking \r\nSpace:");
		label_2_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2_3.setBounds(400, 349, 154, 48);
		contentPane.add(label_2_3);
		
		JButton btn_Add = new JButton("Add Booking");
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isValid = isValidFormat("dd/mm/yyyy", txt_date.getText());
				if(!isValid) {
					JOptionPane.showMessageDialog(null, "The date of the booking must be inputed in the form \"dd/mm/yyyy\"");
				}
			}
		});
		btn_Add.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_Add.setBounds(257, 449, 257, 88);
		contentPane.add(btn_Add);
	}
	
	public static boolean isValidFormat(String format, String value) {
	    Date date = null;
	    try {
	      date = new SimpleDateFormat(format).parse(value);
	    } catch (ParseException ex) {
	      ex.printStackTrace();
	    }
	    return date != null;
	  }
}
