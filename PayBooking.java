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

public class PayBooking extends JFrame {

	private JPanel contentPane;
	public String username = "";
	public String type = "";
	public int amountDue;
	public boolean attended;
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
        type = System.loggedInAccountType
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
		            attended = rd.nextBoolean(); // displaying a random boolean
                    int x = 0;
                    int y = 0;
                    String[] parts9 = duration.split("\r");
                    x = Integer.valueOf(parts9[0]);
                    if(attended = true)
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
		
        String s=String.valueOf(amountDue);  
        returnList.set(6,s);
        
        /*Update backend with new price: commented since I'm not sure if tempClients is remade after being renamed once Clients is deleted(may have to remake it at the end), will test when I'm back
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
                newBalance = x.next();;
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
		*/
        Label label_3 = new Label("$" + returnList.get(6));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(298, 130, 216, 48);
		contentPane.add(label_3);

		JButton btnNewButton = new JButton("Credit");
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnList.set(6,"0");	
                label_3.setText("$" + returnList.get(6));
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(257, 264, 257, 88);
		contentPane.add(btnNewButton);
		
		JButton btnDebt = new JButton("Debit");
        btnDebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnList.set(6,"0");	
                label_3.setText("$" + returnList.get(6));
				
			}
		});
		btnDebt.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnDebt.setBounds(257, 363, 257, 88);
		contentPane.add(btnDebt);
		
		JButton btnOther = new JButton("Other");
        btnOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnList.set(6,"0");	
                label_3.setText("$" + returnList.get(6));
				
			}
		});

        /*Update backend with new value now that price has been paid: commented since I'm not sure if tempClients is remade after being renamed once Clients is deleted(may have to remake it at the end), will test when I'm back
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
                newBalance = x.next();;
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
		*/

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
