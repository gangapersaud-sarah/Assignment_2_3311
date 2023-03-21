import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToolBar;
import javax.swing.JEditorPane;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
/* 
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormSpecs;
*/
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.border.LineBorder;

public class Manager extends JFrame {

	private JPanel contentPane;
	private JTable ValidationTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
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
	public Manager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel landingPage = new JPanel();
		contentPane.add(landingPage, "landingPage");
		landingPage.setLayout(null);
		
		JButton manageParkingButton = new JButton("MANAGE PARKING");
		manageParkingButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		manageParkingButton.setBackground(new Color(204, 204, 153));
		manageParkingButton.setBounds(66, 227, 250, 89);
		landingPage.add(manageParkingButton);
		
		JButton logOutButton = new JButton("LOG OUT");
		logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		logOutButton.setBackground(new Color(204, 204, 153));
		logOutButton.setBounds(438, 372, 250, 90);
		landingPage.add(logOutButton);
		
		JButton ValidateButton = new JButton("VALIDATE ACCOUNTS");
		ValidateButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ValidateButton.setBackground(new Color(204, 204, 153));
		ValidateButton.setBounds(66, 372, 250, 90);
		landingPage.add(ValidateButton);
		
		JButton addClientButton = new JButton("ADD CLIENT TYPE");
		addClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                String name = JOptionPane.showInputDialog("Name of Client Type?", null);
	                }
		});
		addClientButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		addClientButton.setBackground(new Color(204, 204, 153));
		addClientButton.setBounds(438, 227, 250, 89);
		landingPage.add(addClientButton);
		
		JLabel lblNewLabel = new JLabel("Welcome, Manager!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblNewLabel.setBounds(120, 11, 568, 56);
		landingPage.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please Select an Option Below");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(203, 98, 413, 71);
		landingPage.add(lblNewLabel_1);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(204, 204, 153));
		editorPane.setBounds(0, 0, 786, 185);
		landingPage.add(editorPane);
		
		JPanel validateAccounts = new JPanel();
		validateAccounts.setBackground(new Color(255, 255, 255));
		contentPane.add(validateAccounts, "validateAccountsPage");
		validateAccounts.setLayout(null);
		
		JButton backButtonVal = new JButton("Back");
		backButtonVal.setBounds(0, 0, 123, 40);
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
		scrollPane.setBounds(0, 124, 666, 409);
		validateAccounts.add(scrollPane);
		
		ValidationTable = new JTable();
		/*
		 * String[] idk = {"SOMETHING", "HI", "HELLO", "NOOOO"};
				tableModel.addRow(idk);
		 */
		DefaultTableModel tableModel = new DefaultTableModel(
			new Object[][] {
				{null, null, null, ""},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Name", "Email", "Password", "ClientType"
			}
		) 
		
		{
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		scrollPane.setViewportView(ValidationTable);
		ValidationTable.setModel(tableModel);
		
		JButton acceptButton = new JButton("ACCEPT");
		acceptButton.setBounds(663, 124, 123, 204);
		validateAccounts.add(acceptButton);
		
		JButton declineButton = new JButton("DECLINE");
		declineButton.setBounds(663, 329, 123, 204);
		validateAccounts.add(declineButton);
		
		JPanel manageParkingLot = new JPanel();
		manageParkingLot.setBackground(Color.WHITE);
		contentPane.add(manageParkingLot, "manageParkingPage");
		manageParkingLot.setLayout(null);
		
		JLabel parkingLotLabel = new JLabel("Choose a Parking Lot");
		parkingLotLabel.setFont(new Font("Tahoma", Font.PLAIN, 43));
		parkingLotLabel.setBounds(168, 24, 465, 75);
		manageParkingLot.add(parkingLotLabel);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBackground(new Color(204, 204, 153));
		editorPane_2.setBounds(0, 0, 786, 113);
		manageParkingLot.add(editorPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 110, 294, 422);
		manageParkingLot.add(scrollPane_1);
		
		JList list = new JList();
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Trebuchet MS", Font.PLAIN, 39));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Parking Lot A", "Parking Lot B", "Parking Lot C"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});		
		list.setCellRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                 Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                 //CHANGE TO ENABLE/DISABLE
                      if (index %2 == 0 ) {
                           setBackground(Color.GREEN);
                      } 
                      else{
                           setBackground(Color.RED);
                      }
                      if (isSelected) {
                           setBackground(getBackground().darker());
                      }
                 return c;
            }

       });
		scrollPane_1.setViewportView(list);
		
		JLabel lblNewLabel_2 = new JLabel("Existing Parking Lots");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		scrollPane_1.setColumnHeaderView(lblNewLabel_2);
		
		JButton disableParkingLotButton = new JButton("Disable Parking Lot");
		disableParkingLotButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		disableParkingLotButton.setBackground(new Color(204, 204, 153));
		disableParkingLotButton.setBounds(354, 230, 345, 75);
		manageParkingLot.add(disableParkingLotButton);
		
		JButton enableParkingLotButton = new JButton("Enable Parking Lot");
		enableParkingLotButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		enableParkingLotButton.setBackground(new Color(204, 204, 153));
		enableParkingLotButton.setBounds(354, 124, 344, 75);
		manageParkingLot.add(enableParkingLotButton);
		
		JButton addParkingLotButton = new JButton("Add Parking Lot");
		addParkingLotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame popframe = new JFrame();
				popframe.getContentPane().setBackground(Color.WHITE);
				popframe.getContentPane().setLayout(new CardLayout(0, 0));
				
				JPanel popPanel = new JPanel();
				contentPane.add(popPanel);
				popPanel.setLayout(null);
			}
		});
		addParkingLotButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		addParkingLotButton.setBackground(new Color(204, 204, 153));
		addParkingLotButton.setBounds(354, 447, 345, 75);
		manageParkingLot.add(addParkingLotButton);
		
		JButton editParkingLotButton = new JButton("Edit Parking Lot");
		editParkingLotButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		editParkingLotButton.setBackground(new Color(204, 204, 153));
		editParkingLotButton.setBounds(354, 340, 345, 75);
		manageParkingLot.add(editParkingLotButton);
		contentPane.setBounds(100, 100, 800, 570);
		
		
		// BUTTON LISTENERS
		manageParkingButton.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(landingPage);
				contentPane.remove(validateAccounts);
				contentPane.add(manageParkingLot);
			}
		});
		
		
		backButtonVal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(validateAccounts);
				//frame.getContentPane().remove(manageParking);
				contentPane.add(landingPage);
			}
		});
		
		ValidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(landingPage);
				contentPane.remove(manageParkingLot);
				contentPane.add(validateAccounts);
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
