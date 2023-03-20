

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;

public class manageParkingLot {

	private JFrame parkingLotFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageParkingLot window = new manageParkingLot();
					window.parkingLotFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public manageParkingLot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		parkingLotFrame = new JFrame();
		parkingLotFrame.setBounds(100, 100, 800, 570);
		parkingLotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parkingLotFrame.getContentPane().setLayout(null);
		
		JPanel manageParkingLot = new JPanel();
		manageParkingLot.setLayout(null);
		manageParkingLot.setBackground(Color.WHITE);
		manageParkingLot.setBounds(0, 0, 786, 533);
		parkingLotFrame.getContentPane().add(manageParkingLot);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPageManager window = new LandingPageManager();
				window.setVisible(true);
				parkingLotFrame.setVisible(false);
			}
		});
		backButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		backButton.setBackground(new Color(204, 204, 153));
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		backButton.setBounds(-5, -3, 91, 29);
		manageParkingLot.add(backButton);
		
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

		String[] parking = ReadCSV.allParking();
		Hashtable<String, Integer> parkingInfo = new Hashtable<String, Integer>();
		//A,3
		for(int i = 0; i < parking.length; i++){
			parkingInfo.put("Parking Lot " + parking[i].substring(0,1), Integer.valueOf(parking[i].substring(parking[i].length() - 1)));
		}
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = parkingInfo.keySet().toArray(new String[0]);
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
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setFont(new Font("Trebuchet MS", Font.PLAIN, 39));
		scrollPane_1.setViewportView(list);
		
		JLabel lblNewLabel_2 = new JLabel("Existing Parking Lots");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
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
				addParkingLot addParkingLotFrame= new addParkingLot();
				addParkingLotFrame.setVisible(true);
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
		
		editParkingLotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editParkingSpace parkingSpaceFrame= new editParkingSpace();
				parkingSpaceFrame.setVisible(true);
				parkingLotFrame.setVisible(false);
			}
		});
	}

	public void setVisible(boolean b) {
		this.parkingLotFrame.setVisible(b);
	}

}

