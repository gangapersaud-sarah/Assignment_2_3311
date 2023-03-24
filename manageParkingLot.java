
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
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;

public class manageParkingLot {

	public JFrame parkingLotFrame;
	public static JList<String> list;
	public static DefaultListModel<String> model; 
	public static Hashtable<String, ArrayList<Integer>> parkingInfo;
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
		parkingInfo = new Hashtable<String, ArrayList<Integer>>();
		// A,3
		String[] temp = new String[2];
		String key = "";
		for (int i = 0; i < parking.length; i++) {
			temp = parking[i].split(",");
			//key = "Parking Lot " + temp[0];
			key = temp[0];
			if (!parkingInfo.containsKey(key)) {
				ArrayList<Integer> values = new ArrayList<Integer>();
				values.add(Integer.valueOf(temp[1]));
				parkingInfo.put(key, values);
			} else {
				ArrayList<Integer> values = parkingInfo.get(key);
				values.add(Integer.valueOf(temp[1]));
				parkingInfo.put(key, values);
			}			
		}
		model = new DefaultListModel<String>();
		model.addAll(parkingInfo.keySet());
		list = new JList<String>(model);

		list.setCellRenderer(new DefaultListCellRenderer() {

			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if(parkingInfo.get(value)!=null && parkingInfo.get(value).contains(-1)){
						setBackground(Color.RED);
					
				}
				else{
					setBackground(Color.GREEN);
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
		disableParkingLotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!=null){
					String selected = list.getSelectedValue();
					parkingInfo.get(selected).clear();
					parkingInfo.get(selected).add(-1);
					DeleteCSV.RemoveParkingEntry(selected, 0);
					WriteCSV.addDisabled(selected , -1);
					list.clearSelection();
				}
			}
		});
		JButton enableParkingLotButton = new JButton("Enable Parking Lot");
		enableParkingLotButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		enableParkingLotButton.setBackground(new Color(204, 204, 153));
		enableParkingLotButton.setBounds(354, 124, 344, 75);
		manageParkingLot.add(enableParkingLotButton);
		
		enableParkingLotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!=null){
					String selected = list.getSelectedValue();
					parkingInfo.get(selected).removeAll(Collections.singletonList(-1));
					DeleteCSV.RemoveParkingEntry(selected, -1);
					parkingInfo.get(selected).add(0);
					WriteCSV.addDisabled(list.getSelectedValue(), 0);
					list.clearSelection();
				}
			}
		});


		JButton addParkingLotButton = new JButton("Add Parking Lot");
		addParkingLotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Name of Parking Lot?", null);
				if (name!=null) {
					ArrayList<Integer> val = new ArrayList<Integer>();
					val.add(0);
					parkingInfo.put(name, val);
					model.addElement(name);
					WriteCSV.addDisabled(name, 0);
			   }
				// addParkingLot addParkingLotFrame = new addParkingLot();
				// addParkingLotFrame.setVisible(true);
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
				editParkingSpace parkingSpaceFrame = new editParkingSpace();
				parkingSpaceFrame.setVisible(true);
				parkingLotFrame.setVisible(false);
			}
		});
	}

	public void setVisible(boolean b) {
		this.parkingLotFrame.setVisible(b);
	}
}
