import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;


public class View_Bookings extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
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
					View_Bookings frame = new View_Bookings();
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
	public View_Bookings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewBooking = new JLabel("View Booking");
		lblViewBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewBooking.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblViewBooking.setBackground(Color.LIGHT_GRAY);
		lblViewBooking.setBounds(39, 0, 701, 100);
		contentPane.add(lblViewBooking);
		
		JButton btnNewButton = new JButton("Extend Booking");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(63, 416, 200, 100);
		contentPane.add(btnNewButton);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ExtendBooking newFrame = new ExtendBooking();
//				newFrame.setVisible(true);
//				setVisible(false);
//			}
//		});
		
		JButton btnNewButton_1 = new JButton("Edit Booking");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(288, 416, 200, 100);
		contentPane.add(btnNewButton_1);
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				EditBooking newFrame = new EditBooking();
//				newFrame.setVisible(true);
//				setVisible(false);
//			}
//		});
		
		JButton btnNewButton_2 = new JButton("Cancel Booking");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lp = "";
				String pl = "";
				String ps = "";
				String date = "";
				String time = "";
				String duration = "";
				
				lp = (String) table.getValueAt(table.getSelectedRow(), 0);
				pl = (String) table.getValueAt(table.getSelectedRow(), 1);
				ps = (String) table.getValueAt(table.getSelectedRow(), 2);
				date = (String) table.getValueAt(table.getSelectedRow(), 3);
				time = (String) table.getValueAt(table.getSelectedRow(), 4);
				duration = (String) table.getValueAt(table.getSelectedRow(), 5);
				
				if(duration.contains("\r")) {
					String[] parts = duration.split("\r");
					duration = parts[0];
				}
				
				try {
					DeleteCSV.CancelBooking("HappyBuddy77", lp, pl, ps, date, time, duration);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(513, 416, 200, 100);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 131, 650, 245);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"License Plate", "Parking Lot", "Parking Space", "date", "time", "duration"
				}
			) 
		{
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>();
		returnList = ReadCSV.allBookings("Booking.txt");
		String[] list = new String[6];
		for (int i = 0; i < returnList.size(); i++) {
            for (int j = 0; j < returnList.get(i).size()-1; j++) {
                list[j] = returnList.get(i).get(j+1);
            }
            tableModel.addRow(list);
        }
		
		//String[] list2 = {"1", "2", "3", "4", "5", "6"};
		//tableModel.addRow(l);
		
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		
		textField = new JTextField();
		textField.setBackground(new Color(192, 192, 192));
		textField.setBounds(0, 0, 800, 100);
		contentPane.add(textField);
		textField.setColumns(10);
		table.getColumnModel().getColumn(4).setPreferredWidth(107);
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
