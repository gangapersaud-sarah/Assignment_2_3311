
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class validateAccounts {

	private JFrame validateAccountsFrame;
	private JTable validateTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					validateAccounts window = new validateAccounts();
					window.validateAccountsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public validateAccounts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		validateAccountsFrame = new JFrame();
		validateAccountsFrame.setBounds(100, 100, 800, 570);
		validateAccountsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validateAccountsFrame.getContentPane().setLayout(null);
		
		JPanel validateAccounts = new JPanel();
		validateAccounts.setLayout(null);
		validateAccounts.setBackground(Color.WHITE);
		validateAccounts.setBounds(0, 0, 786, 533);
		validateAccountsFrame.getContentPane().add(validateAccounts);
		
		JButton backButtonVal = new JButton("Back");
		backButtonVal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPageManager newFrame = new LandingPageManager ();
				newFrame.setVisible(true);
				validateAccountsFrame.setVisible(false);
			}
		});
		backButtonVal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		backButtonVal.setBackground(new Color(204, 204, 153));
		backButtonVal.setBounds(-3, -5, 123, 40);
		validateAccounts.add(backButtonVal);
		
		JLabel outstandingValidationLabel = new JLabel("Outstanding Validations");
		outstandingValidationLabel.setFont(new Font("Tahoma", Font.PLAIN, 43));
		outstandingValidationLabel.setBounds(175, 27, 465, 75);
		validateAccounts.add(outstandingValidationLabel);
		
		JEditorPane goldColor = new JEditorPane();
		goldColor.setBackground(new Color(204, 204, 153));
		goldColor.setBounds(0, 0, 786, 123);
		validateAccounts.add(goldColor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 124, 722, 409);
		validateAccounts.add(scrollPane);
		
		validateTable = new JTable();
		ArrayList<ArrayList<String>>  test = ReadCSV.allUsers("validatingClients.txt");
		String[][] stringArray = test.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

		DefaultTableModel tableModel = new DefaultTableModel(
			stringArray,
			new String[] {
				"Username", "First Name", "Last Name" , "Email", "Password", "Client-Type"
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
		scrollPane.setViewportView(validateTable);
		validateTable.setModel(tableModel);
		
		JButton acceptButton = new JButton("ACCEPT");
		acceptButton.setBackground(new Color(204, 204, 153));
		acceptButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		acceptButton.setBounds(720, 124, 66, 204);
		validateAccounts.add(acceptButton);
		//String username, String first, String last, String email, String pwd, String type
		acceptButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int row = validateTable.getSelectedRow();
				while(row != -1){					
					WriteCSV.saveClient(tableModel.getValueAt(row, 0).toString(), tableModel.getValueAt(row, 1).toString(), tableModel.getValueAt(row, 2).toString(), tableModel.getValueAt(row, 3).toString(), tableModel.getValueAt(row, 4).toString(), tableModel.getValueAt(row, 5).toString());
					//REMOVE FROM VALIDATING CLIENTS FILE
					tableModel.removeRow(row);
					row = validateTable.getSelectedRow();
				}
                tableModel.fireTableDataChanged();
			}
		});

		JButton declineButton = new JButton("DECLINE");
		declineButton.setBackground(new Color(204, 204, 153));
		declineButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		declineButton.setBounds(720, 329, 66, 204);
		validateAccounts.add(declineButton);

		declineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = validateTable.getSelectedRow();
				while(row != -1){
					//REMOVE FROM VALIDATING CLIENTS FILE
					tableModel.removeRow(row);
					row = validateTable.getSelectedRow();
				}
                tableModel.fireTableDataChanged();
			}
		});

	}

	public void setVisible(boolean b) {
		this.validateAccountsFrame.setVisible(b);
	}
}

