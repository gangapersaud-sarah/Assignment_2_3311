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

public class AddBooking extends JFrame {

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
		label_2.setBounds(33, 349, 130, 48);
		contentPane.add(label_2);
		
		Label label_2_1 = new Label("Duration:");
		label_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2_1.setBounds(400, 349, 140, 48);
		contentPane.add(label_2_1);
		
		JTextField txt_lp = new JTextField();
		txt_lp.setBounds(193, 171, 178, 48);
		contentPane.add(txt_lp);
		txt_lp.setColumns(10);
		
		JComboBox cmb_time = new JComboBox();
		cmb_time.setBounds(193, 349, 178, 48);
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
		cmb_duration.setBounds(577, 349, 178, 48);
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
		
		JComboBox cmb_ps = new JComboBox();
		cmb_ps.setBounds(577, 261, 178, 48);
		contentPane.add(cmb_ps);
		
		JComboBox cmb_pl = new JComboBox();
		cmb_pl.setBounds(577, 171, 178, 48);
		contentPane.add(cmb_pl);
		cmb_pl.addItem("Select");
		
		String[] allPL = ReadCSV.allParkingLots();
		ReadCSV.allParkingLots();
		for(int i = 0; i < allPL.length; i++) {
			cmb_pl.addItem("Parking Lot: " + (String)allPL[i]);
		}
		
		cmb_pl.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	cmb_ps.removeAllItems();
		    	String s = (String) cmb_pl.getSelectedItem();
		    	if(!s.equals("Select")) {
		    		cmb_ps.addItem("Select");
		    		String[] parts = s.split(": ");
			    	String part2 = parts[1];
			    	String[] allPS = ReadCSV.parkingSpacesOfLot(part2);
			    	
			    	ArrayList<Integer> allSpaces = new ArrayList<Integer>();
			    	for(int i = 1; i < 101; i++) {
			    		allSpaces.add(i);
			    	}
					for(int i = 0; i < allPS.length; i++) {
						String[] parts3 = allPS[i].split("\r");
				    	String part4 = parts3[0];
						Integer arr = Integer.valueOf(part4);
						if(allSpaces.contains(arr)) {
							allSpaces.remove(arr);
						}
					}
					for(int i = 0; i < allSpaces.size(); i++) {
						cmb_ps.addItem("Parking Space: " + allSpaces.get(i));
					}
		    	}
		    	else {
		    		JOptionPane.showMessageDialog(null, "Please Choose a parking Lot");
		    	}
		    }
		});
		
		
		cmb_ps.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				cmb_time.removeAllItems();
		    	String s = (String) cmb_ps.getSelectedItem();
		    	if(!s.equals("Select")) {
		    		cmb_time.addItem("Select");
		    		String[] parts = s.split(": ");
			    	String part2 = parts[1];
		    	}
			}
		});
		
		Label label_2_2 = new Label("Parking Lot:");
		label_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2_2.setBounds(400, 171, 140, 48);
		contentPane.add(label_2_2);

		
		Label label_2_3 = new Label("Parking \r\nSpace:");
		label_2_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2_3.setBounds(400, 261, 154, 48);
		contentPane.add(label_2_3);
		
		JButton btn_Add = new JButton("Add Booking");
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isValid = isValidFormat("dd/MM/yyyy", txt_date.getText(), Locale.ENGLISH);
				if(!isValid) {
					JOptionPane.showMessageDialog(null, "The date of the booking must be inputed in the form \"dd/MM/yyyy\"");
				}
			}
		});
		btn_Add.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_Add.setBounds(257, 449, 257, 88);
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
}
