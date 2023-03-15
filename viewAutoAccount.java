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
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class viewAutoAccount extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewAutoAccount frame = new viewAutoAccount();
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
	public viewAutoAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblViewBooking = new JLabel("View Auto Accounts");
		lblViewBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewBooking.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblViewBooking.setBackground(Color.LIGHT_GRAY);
		lblViewBooking.setBounds(39, 0, 701, 100);
		contentPane.add(lblViewBooking);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 131, 650, 245);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
		returnList = ReadCSV.allUsers("Clients.txt");
		String[] list = new String[6];
		for (int i = 0; i < returnList.size(); i++) {
			for (int j = 0; j < returnList.get(i).size(); j++) {
                list[j] = returnList.get(i).get(j);
            }

			if(list[5].equals(" Manager"))
			{
				tableModel.addRow(list);
			}
        }
		
		
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		
		textField = new JTextField();
		textField.setBackground(new Color(192, 192, 192));
		textField.setBounds(0, 0, 800, 100);
		contentPane.add(textField);
		textField.setColumns(10);
		table.getColumnModel().getColumn(4).setPreferredWidth(107);
	}
}
