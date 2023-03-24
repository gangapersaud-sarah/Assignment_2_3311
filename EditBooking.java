import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.io.File;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.io.File;


public class EditBooking extends JFrame {
	
	private JPanel contentPane;
	public String username = "";
	public String type = "";
	public int amountDue = -1;
	private static Scanner x;
//	private JFrame frame;
//	private JTextField textField;
//	private JTextField textField_1;
	public String lp;
	public String pl;
	public String ps;
	public String date;
	public String time;
	public String duration;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditBooking window = new EditBooking();
					window.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Booking");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 56));
		lblNewLabel.setBounds(0, 0, 786, 124);
		getContentPane().add(lblNewLabel);
		
//		Label label = new Label("License Plate:");
//		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		label.setBounds(33, 171, 154, 48);
//		contentPane.add(label);
		
		Label label_1 = new Label("Date:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(193, 171, 154, 48);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Time:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(193, 261, 130, 48);
		contentPane.add(label_2);
		
		Label label_2_1 = new Label("Duration:");
		label_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2_1.setBounds(193, 349, 178, 48);
		contentPane.add(label_2_1);
		
//		JTextField txt_lp = new JTextField();
//		txt_lp.setBounds(193, 171, 178, 48);
//		contentPane.add(txt_lp);
//		txt_lp.setColumns(10);
//		
		JTextField txt_date = new JTextField();
		txt_date.setBounds(393, 171, 178, 48);
		contentPane.add(txt_date);
		
		JComboBox cmb_time = new JComboBox();
		cmb_time.setBounds(393, 261, 178, 48);
		contentPane.add(cmb_time);
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
		
		JComboBox cmb_duration = new JComboBox();
		cmb_duration.setBounds(393, 349, 178, 48);
		contentPane.add(cmb_duration);
		cmb_duration.addItem("1 Hour");
		cmb_duration.addItem("2 Hours");
		cmb_duration.addItem("3 Hours");
		cmb_duration.addItem("4 Hours");
		cmb_duration.addItem("5 Hours");
		cmb_duration.addItem("6 Hours");
		
	
		JButton btn_Add = new JButton("Update Booking");
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isValid = isValidFormat("dd/MM/yyyy", txt_date.getText(), Locale.ENGLISH);
				if(!isValid) {
					JOptionPane.showMessageDialog(null, "The date of the booking must be inputed in the form \"dd/MM/yyyy\"");
				}
				else {
					String t = (String) cmb_time.getSelectedItem();
					String[] parts = t.split(":");
			    	String finalStart = parts[0];
			    	
			    	String d = (String) cmb_duration.getSelectedItem();
					String[] parts2 = d.split(" Hours");
			    	String finalDuration = parts2[0];
			    	
			    	ArrayList<Integer> allTimes = new ArrayList<Integer>();
			    	for(int i = 8; i < 23; i++) {
		    			allTimes.add(i);
			    	}
			    	
					try {
						DeleteCSV.CancelBooking(username, lp, pl, ps, date, time, duration);
						
						ArrayList<ArrayList<String>> booking = ReadCSV.allBookings("Booking.txt");
				    	for(int i = 0; i < booking.size(); i++) {
				    		if(booking.get(i).get(2).equals(pl) && booking.get(i).get(3).equals(ps) && booking.get(i).get(4).equals(txt_date.getText())) {
						    	String[] parts5 = booking.get(i).get(6).split("\r");
						    	String finalDurationI = parts5[0];
				    			for(int k = Integer.valueOf(booking.get(i).get(5)); k < Integer.valueOf(booking.get(i).get(5)) + Integer.valueOf(finalDurationI); k++) {
				    				if(allTimes.contains(k)) {
				    					allTimes.remove((Integer) k);
										
									}
								}
				    		}
				    	}
				    	boolean valid = true;
				    	for(int i = Integer.valueOf(finalStart); i < Integer.valueOf(finalStart) + Integer.valueOf(finalDuration); i++) {
							if(!allTimes.contains(i)) {
								valid = false;
							}
						}
				    	
				    	if(valid) {
							WriteCSV.CreateBooking(username, lp, pl, ps, txt_date.getText(), finalStart, finalDuration);
							JOptionPane.showMessageDialog(null, "Booking Edited");
				    	}
				    	else {
				    		WriteCSV.CreateBooking(username, lp, pl, ps, date, time, duration);
							JOptionPane.showMessageDialog(null, "Booking not Edited, time and duration of booking is unavalible");
				    	}
				    					    	
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}		
			}
		});
		btn_Add.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_Add.setBounds(239, 464, 293, 88);
		contentPane.add(btn_Add);
	
	}
	
	public static boolean isValidFormat(String format, String value, Locale locale) {
	    LocalDateTime ldt = null;
	    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

	    try {
	        ldt = LocalDateTime.parse(value, fomatter);
	        String result = ldt.format(fomatter);
	        return result.equals(value);
	    } catch (DateTimeParseException e) {
	        try {
	            LocalDate ld = LocalDate.parse(value, fomatter);
	            String result = ld.format(fomatter);
	            return result.equals(value);
	        } catch (DateTimeParseException exp) {
	            try {
	                LocalTime lt = LocalTime.parse(value, fomatter);
	                String result = lt.format(fomatter);
	                return result.equals(value);
	            } catch (DateTimeParseException e2) {
	                // Debugging purposes
	                //e2.printStackTrace();
	            }
	        }
	    }

	    return false;
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
	
	public void setLP(String s) {
		lp = s;
	}
	public void setPL(String s) {
		pl = s;
	}
	public void setPS(String s) {
		ps = s;
	}
	public void setDate(String s) {
		date = s;
	}
	public void setTime(String s) {
		time = s;
	}
	public void setDuration(String s) {
		duration = s;
	}
}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 800, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("Edit Booking");
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 56));
//		lblNewLabel.setBounds(0, 0, 786, 124);
//		frame.getContentPane().add(lblNewLabel);
//		
//		JButton btnNewButton = new JButton("Update Booking");
//		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
//		btnNewButton.setBounds(239, 464, 293, 88);
//		frame.getContentPane().add(btnNewButton);
//		
//		Label label = new Label("License Plate:");
//		label.setFont(new Font("Tahoma", Font.BOLD, 20));
//		label.setBounds(52, 178, 216, 48);
//		frame.getContentPane().add(label);
//		
//		Label label_1 = new Label("Date:");
//		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
//		label_1.setBounds(52, 247, 199, 48);
//		frame.getContentPane().add(label_1);
//		
//		Label label_2 = new Label("Time:");
//		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
//		label_2.setBounds(52, 316, 199, 48);
//		frame.getContentPane().add(label_2);
//		
//		Label label_2_1 = new Label("Duration:");
//		label_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
//		label_2_1.setBounds(52, 391, 199, 48);
//		frame.getContentPane().add(label_2_1);
//		
//		textField = new JTextField();
//		textField.setBounds(334, 178, 316, 48);
//		frame.getContentPane().add(textField);
//		textField.setColumns(10);
//		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(334, 316, 316, 48);
//		frame.getContentPane().add(comboBox);
//		
//		JComboBox comboBox_1 = new JComboBox();
//		comboBox_1.setBounds(334, 391, 316, 48);
//		frame.getContentPane().add(comboBox_1);
//		
//		textField_1 = new JTextField();
//		textField_1.setBounds(334, 247, 316, 48);
//		frame.getContentPane().add(textField_1);
//		
//		textField = new JTextField();
//		textField.setBounds(334, 206, 96, 20);
//		frame.getContentPane().add(textField);
//		textField.setColumns(10);
//		
//		textField_1 = new JTextField();
//		textField_1.setColumns(10);
//		textField_1.setBounds(334, 247, 316, 48);
//		frame.getContentPane().add(textField_1);
//		textField_1.setColumns(10);
//		
//	}

