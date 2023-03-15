import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class viewAutoAccount{
	 JFrame frame = new JFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			viewAutoAccount s = new viewAutoAccount();
			s.frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public viewAutoAccount() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		JPanel contentPane = new JPanel();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblViewBooking = new JLabel("View Auto Accounts");
		lblViewBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewBooking.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblViewBooking.setBackground(Color.LIGHT_GRAY);
		lblViewBooking.setBounds(39, 0, 701, 100);
		contentPane.add(lblViewBooking);

		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 131, 650, 245);
		contentPane.add(scrollPane);
		
		JTable table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"Username", "First name", "Last name", "Email", "Password", "Type"
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
		returnList = ReadCSV.allUsers("Clients.csv");
		String[] list = new String[6];
		for (int i = 0; i < returnList.size(); i++) {
			for (int j = 0; j < returnList.get(i).size(); j++) {
                list[j] = returnList.get(i).get(j);
            }

			if(list[1].equals(" null"))
			{
				tableModel.addRow(list);
			}
        }
		
		
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		
		JButton button = new JButton("Return");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				superManagerMainPage a2 = new superManagerMainPage();
				a2.frame.setVisible(true);
			}
		});
		
		button.setBounds(10, 494, 124, 45);
		contentPane.add(button);
		table.getColumnModel().getColumn(4).setPreferredWidth(107);
	}
}
