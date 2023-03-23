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
	private static Scanner x;

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
				username = System.loggedInUserName;
				type = System.loggedInAccountType;
				ArrayList<String> returnList = new ArrayList<String>();
				char bookDurationChar = comboBox.getSelectedItem().toString().charAt(0);
				int bookDuration = Character.getNumericValue(bookDurationChar);
				returnList = ReadCSV.findUserName(username, "Clients.txt");
				if(type.equals("Student"))
				{
					String s=String.valueOf(5 * bookDuration + 5);  
					returnList.set(6,s);
				}
				else if (type.equals("Faculty"))
				{
					String s=String.valueOf(8 * bookDuration + 8);  
					returnList.set(6,s);
				}
				else if (type.equals("non-Faculty"))
				{
					String s=String.valueOf(10 * bookDuration + 10);  
					returnList.set(6,s);
				}
				else
				{
					String s=String.valueOf(15 * bookDuration + 15);  
					returnList.set(6,s);
				}
				String filePath = "Clients.txt";
				String tempFile = "tempClients.txt";
				File oldFile = new File(filePath);
				File newFile = new File(tempFile);
				String newUserName = ""; String newFirstName = ""; String newLastName = ""; String newEmail = ""; String newPassword = ""; String newType = ""; String newBalance = "";
				try
				{
					FileWriter fw = new FileWriter(tempFile, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					x = new Scanner(filePath);
					x.useDelimiter("[,\n]");
					while(x.hasNext())
					{
						newUserName = x.next();
						newFirstName = x.next();
						newLastName = x.next();
						newEmail = x.next();
						newPassword = x.next();
						newType = x.next();
						newBalance = x.next();
						if(newUserName.equals(username))
						{
							pw.println(username + "," + returnList.get(1) + "," + returnList.get(2) + "," + returnList.get(3) + "," + returnList.get(4) + "," + type + "," + returnList.get(6));
						}
						else
						{
							pw.println(newUserName + "," + newFirstName + "," + newLastName + "," + newEmail + "," + newPassword + "," + newType + "," + newBalance);
						}
					}
					x.close();
					pw.flush();
					pw.close();
					oldFile.delete();
					File dump = new File(filePath);
					newFile.renameTo(dump);
				}
				catch(Exception e2)
				{

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(252, 398, 293, 88);
		contentPane.add(btnNewButton);
	}
	
//	    LocalDateTime ldt = null;
//	    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);
//
//	    try {
//	        ldt = LocalDateTime.parse(value, fomatter);
//	        String result = ldt.format(fomatter);
//	        return result.equals(value);
//	    } catch (DateTimeParseException e) {
//	        try {
//	            LocalDate ld = LocalDate.parse(value, fomatter);
//	            String result = ld.format(fomatter);
//	            return result.equals(value);
//	        } catch (DateTimeParseException exp) {
//	            try {
//	                LocalTime lt = LocalTime.parse(value, fomatter);
//	                String result = lt.format(fomatter);
//	                return result.equals(value);
//	            } catch (DateTimeParseException e2) {
//	                // Debugging purposes
//	                //e2.printStackTrace();
//	            }
//	        }
//	    }
//
//	    return false;
//	}

}
