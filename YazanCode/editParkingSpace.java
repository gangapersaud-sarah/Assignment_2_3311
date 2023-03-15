package YazanCode;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class editParkingSpace {

	private JFrame parkingSpaceFrame;
	private JTable parkingSpaceTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editParkingSpace window = new editParkingSpace();
					window.parkingSpaceFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public editParkingSpace() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		parkingSpaceFrame = new JFrame();
		parkingSpaceFrame.setBounds(100, 100, 800, 570);
		parkingSpaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parkingSpaceFrame.getContentPane().setLayout(null);
		
		JPanel manageParkingSpace = new JPanel();
		manageParkingSpace.setLayout(null);
		manageParkingSpace.setBounds(0, 0, 796, 533);
		parkingSpaceFrame.getContentPane().add(manageParkingSpace);
		
		JScrollPane ParkingSpaceScrollPane = new JScrollPane();
		ParkingSpaceScrollPane.setName("ParkingSpaceScrollPane");
		ParkingSpaceScrollPane.setBounds(0, 0, 786, 511);
		manageParkingSpace.add(ParkingSpaceScrollPane);
		
		parkingSpaceTable = new JTable();
		parkingSpaceTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		parkingSpaceTable.setName("ParkingSpaceTable");
		String[][] tableFilled= fillTable();
		DefaultTableModel tableModel = new DefaultTableModel( tableFilled, new String[] {"Space #", "Status", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"}) 
		{
		Class[] columnTypes = new Class[] {
			String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
		boolean[] columnEditables = new boolean[] {
			false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
		};
		parkingSpaceTable.setModel(tableModel);
		
		parkingSpaceTable.getColumnModel().getColumn(0).setMinWidth(74);
		parkingSpaceTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 2; i < parkingSpaceTable.getColumnModel().getColumnCount(); i++) {
			parkingSpaceTable.getColumnModel().getColumn(i).setMinWidth(55);
			parkingSpaceTable.getColumnModel().getColumn(i).setCellRenderer(new ColorRenderer());
		}
		ParkingSpaceScrollPane.setViewportView(parkingSpaceTable);
		
		JButton enableParkingSpace = new JButton("Enabled Selected Parking Space");
		enableParkingSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rows = parkingSpaceTable.getSelectedRows();
				for (int i =0; i < rows.length; i++) {
					if(rows[i] !=1) {
						tableModel.setValueAt("enabled", rows[i], 1);
						tableModel.fireTableCellUpdated(rows[i], 1);
					}
				}
				
			}
		});
		enableParkingSpace.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		enableParkingSpace.setBackground(Color.WHITE);
		enableParkingSpace.setFont(new Font("Tahoma", Font.PLAIN, 17));
		enableParkingSpace.setBounds(94, 510, 297, 23);
		manageParkingSpace.add(enableParkingSpace);
		
		JButton disableParkingSpace = new JButton("Disable Selected Parking Space");
		disableParkingSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rows = parkingSpaceTable.getSelectedRows();
				for (int i =0; i < rows.length; i++) {
					if(rows[i] !=1) {
						tableModel.setValueAt("disabled", rows[i], 1);
						tableModel.fireTableDataChanged();
					}
				}
			}
		});
		disableParkingSpace.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		disableParkingSpace.setBackground(Color.WHITE);
		disableParkingSpace.setFont(new Font("Tahoma", Font.PLAIN, 17));
		disableParkingSpace.setBounds(392, 510, 393, 23);
		manageParkingSpace.add(disableParkingSpace);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageParkingLot parkingLotFrame= new manageParkingLot();
				parkingLotFrame.setVisible(true);
				parkingSpaceFrame.setVisible(false);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(0, 510, 93, 23);
		manageParkingSpace.add(backButton);
	}
	
	public String[][] fillTable(){
		String[][] table = new String[100][20];

		for (int i = 0; i < 100; i++) {
		    table[i][0] = Integer.toString(i + 1);
		    table[i][1] = "enabled";
		    for (int j = 2; j < 20; j++) {
		        table[i][j] = "";
		    }
		}
		return table;
	}

	public void setVisible(boolean b) {
		this.parkingSpaceFrame.setVisible(b);
	}
}


