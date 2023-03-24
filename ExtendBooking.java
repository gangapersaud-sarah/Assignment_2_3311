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


public class ExtendBooking extends JFrame  {

	public JPanel contentPane;
	public String username = "";
	public String type = "";
	public int amountDue = -1;
	
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
					ExtendBooking window = new ExtendBooking();
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
	public ExtendBooking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Extend Booking");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 56));
		lblNewLabel.setBounds(0, 0, 786, 124);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select How Long You Want To Extend Your Booking For:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(55, 149, 673, 79);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(198, 261, 386, 79);
		contentPane.add(comboBox);
		comboBox.addItem("1 Hour");
		comboBox.addItem("2 Hours");
		comboBox.addItem("3 Hours");
		comboBox.addItem("4 Hours");
		comboBox.addItem("5 Hours");
		comboBox.addItem("6 Hours");
		
		JButton btnNewButton = new JButton("Extend Booking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			    	String d = (String) comboBox.getSelectedItem();
					String[] parts2 = d.split(" Hours");
			    	String finalDuration = parts2[0];
					try {
						DeleteCSV.CancelBooking("HappyBuddy77", lp, pl, ps, date, time, duration);
						WriteCSV.CreateBooking("HappyBuddy77", lp, pl, ps, date, time, finalDuration);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(252, 398, 293, 88);
		contentPane.add(btnNewButton);
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

