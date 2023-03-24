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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class PayBooking extends JFrame {

	private JPanel contentPane;
	public String username = "";
	public String type = "";
	public int amountDue;
	public int attended;
    private static Scanner x;

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

		username = System.loggedInUserName;
        type = System.loggedInAccountType;
        ArrayList<String> returnList = new ArrayList<String>();
        returnList = ReadCSV.findUserName(username, "Clients.txt");
		amountDue = 0;
        String userName = "";
        String lp = "";
        String pl = "";
        String ps = "";
        String date = "";
        String time = "";
        String duration = "";
        
        try {
            
            // create reading tools, x is the file
            x = new Scanner(new File("Booking.txt"));
            // Separate values in x using "," and "\n"
            x.useDelimiter("[,\n]");
            
            while (x.hasNext()) {
                
                // get next line
                userName = x.next();
                lp = x.next();
                pl = x.next();
                ps = x.next();
                date = x.next();
                time = x.next();
                duration = x.next();
                
                // when booking is found (unique usernames)
                if(userName.equals(username)) {
                    // add the booking details to the array
                    Random rd = new Random(); // creating Random object
		            attended = rd.nextInt(2); // displaying a random boolean
                    int x = 0;
                    int y = 0;
                    String[] parts9 = duration.split("\r");
                    x = Integer.valueOf(parts9[0]);
                    if(attended == 0)
		            {
                        if(type.equals("Student"))
                        {
                            y = (x * 5);
                        }
                        else if(type.equals("Faculty"))
                        {
                            y = (x * 8);
                        }
                        else if(type.equals("non-Faculty"))
                        {
                            y = (x * 10);
                        }
                        else
                        {
                            y = (x * 15);
                        }
		            }
                    else
                    {
                        if(type.equals("Student"))
                        {
                            y = (x * 5) + 5;
                        }
                        else if(type.equals("Faculty"))
                        {
                            y = (x * 8) + 8;
                        }
                        else if(type.equals("non-Faculty"))
                        {
                            y = (x * 10) + 10;
                        }
                        else
                        {
                            y = (x * 15) + 15;
                        }
                    }
                    amountDue += y;
                }  
            }
        }
        catch (Exception e){
            
        }
		
        try {
            DeleteCSV.CancelClient(username,returnList.get(1), returnList.get(2), returnList.get(3), returnList.get(4), type, returnList.get(6));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String s=String.valueOf(amountDue);  
        returnList.set(6,s);
        WriteCSV.saveClient(username,returnList.get(1), returnList.get(2), returnList.get(3), returnList.get(4), type, amountDue);

        String temp_username = returnList.get(0);
        String temp_fname = returnList.get(1);
        String temp_lname = returnList.get(2);
        String temp_email = returnList.get(3);
        String temp_pw = returnList.get(4);
        String temp_amnt = returnList.get(6);

        
        Label label_3 = new Label("$" + returnList.get(6));
        label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        label_3.setBounds(298, 130, 216, 48);
        contentPane.add(label_3);

        JButton btnNewButton = new JButton("Credit");
        btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            amountDue = 0;
            try {
                DeleteCSV.CancelClient(temp_username,temp_fname, temp_lname, temp_email, temp_pw, type, temp_amnt);
            } catch (IOException e3) {
                // TODO Auto-generated catch block
                e3.printStackTrace();
            }
            WriteCSV.saveClient(temp_username,temp_fname, temp_lname, temp_email, temp_pw, type, amountDue);
            label_3.setText("$0");
        }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton.setBounds(257, 264, 257, 88);
        contentPane.add(btnNewButton);
            
        JButton btnDebt = new JButton("Debit");
        btnDebt.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            amountDue = 0;
            try {
                DeleteCSV.CancelClient(temp_username,temp_fname, temp_lname, temp_email, temp_pw, type, temp_amnt);
            } catch (IOException e3) {
                // TODO Auto-generated catch block
                e3.printStackTrace();
            }
            WriteCSV.saveClient(temp_username,temp_fname, temp_lname, temp_email, temp_pw, type, amountDue);
            label_3.setText("$0");
        }
        });
        btnDebt.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnDebt.setBounds(257, 363, 257, 88);
        contentPane.add(btnDebt);
            
        JButton btnOther = new JButton("Other");
        btnOther.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            amountDue = 0;
            try {
                DeleteCSV.CancelClient(temp_username,temp_fname, temp_lname, temp_email, temp_pw, type, temp_amnt);
            } catch (IOException e3) {
                // TODO Auto-generated catch block
                e3.printStackTrace();
            }
            WriteCSV.saveClient(temp_username,temp_fname, temp_lname, temp_email, temp_pw, type, amountDue);
            label_3.setText("$0");
        }
        });	
        btnOther.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnOther.setBounds(257, 462, 257, 88);
        contentPane.add(btnOther);

        JLabel label_2 = new JLabel("New label");
        label_2.setBounds(207, 135, 49, 14);
	    contentPane.add(label_2);

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
