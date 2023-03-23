

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class addParkingLot{

	private JFrame addParkingLot;
	private JTextField nameTF;
	public String name = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addParkingLot window = new addParkingLot();
					window.addParkingLot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addParkingLot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addParkingLot = new JFrame();
		addParkingLot.setBounds(100, 100, 406, 261);
		addParkingLot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addParkingLot.getContentPane().setLayout(null);
		
		JLabel NameLabel = new JLabel("Name:");
		NameLabel.setBackground(new Color(204, 204, 153));
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		NameLabel.setBounds(10, 33, 90, 46);
		addParkingLot.getContentPane().add(NameLabel);
		
		nameTF = new JTextField();
		nameTF.setBackground(new Color(204, 204, 153));
		nameTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameTF.setBounds(110, 36, 247, 52);
		addParkingLot.getContentPane().add(nameTF);
		nameTF.setColumns(10);
		JButton submitButton = new JButton("Submit");
		submitButton.setBackground(new Color(204, 204, 153));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = nameTF.getText();
				if (!name.equals("")) {
					 manageParkingLot.model.addElement(name);
					 manageParkingLot.model.lastElement();
					 ArrayList<Integer> val = new ArrayList<Integer>();
					 val.add(0);
					 manageParkingLot.parkingInfo.put(name, val);
					 WriteCSV.addDisabled(name, 0);
					addParkingLot.setVisible(false);
				}
			}
		});
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 31));
		submitButton.setBounds(20, 130, 354, 70);
		addParkingLot.getContentPane().add(submitButton);
	}
	public void setVisible(boolean b) {
		addParkingLot.setVisible(b);		
	}
}
