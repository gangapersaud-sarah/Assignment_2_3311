import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class viewAutoAccount extends JFrame {

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
					"User Name", "First Name", "Last Name", "Email", "Password", "Type", "Balance"
				}
			) 
		{
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
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
		String[] list = new String[7];
		for (int i = 0; i < returnList.size(); i++) {
            for (int j = 0; j < returnList.get(i).size(); j++) {
                list[j] = returnList.get(i).get(j);

            }
			if(list[5].equals("Manager"))
			{
				tableModel.addRow(list);
			}
	
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
	
	public int numberRows()
	{
		return table.getRowCount();
	}
	
	public int numberColumns()
	{
		return table.getColumnCount();
	}
	
	public Object[] getAutoAccount(int rowNum)
	{
		Object[] rowData = new Object[7];
		for (int i = 0; i < 7; i++)
		{
			rowData[i] = table.getValueAt(rowNum, i);
		}
		
		return rowData;
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

