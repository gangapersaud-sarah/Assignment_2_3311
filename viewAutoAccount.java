package windows_builder_test;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

public class viewAutoAccount {
    JFrame frame = new JFrame();
    JTextField txt_username = new JTextField();
    JTextField txt_password = new JTextField();
    JLabel lblNewLabel = new JLabel("");
    JButton btnNewButton = new JButton("Enter");
    private JTable table_1;

    public viewAutoAccount() {
        
        frame = new JFrame();
		frame.setBounds(100, 100, 451, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 231, 415, -168);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		//Pull data from backend
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Username", "Password"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.setBounds(20, 63, 405, 156);
		panel.add(table_1);
		
		JButton btn_return = new JButton("Return");
		btn_return.setBounds(10, 231, 89, 23);
		panel.add(btn_return);
		
		JLabel lbl_title = new JLabel("View Auto Account");
		lbl_title.setBounds(171, 11, 254, 30);
		panel.add(lbl_title);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setBounds(62, 37, 112, 23);
		panel.add(lbl_username);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setBounds(254, 37, 128, 26);
		panel.add(lbl_password);
		
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				superManagerMainPage a2 = new superManagerMainPage();
				a2.frame.setVisible(true);
			}
		});
		
    }

    // validate user email when user signs up
    public boolean authenticateEmail() {
        return true;
    }

    // validate user password when user signs up
    public boolean authenticatePassword() {
        return true;
    }

    public static void main(String args[]) {
        viewAutoAccount s = new viewAutoAccount();
        s.frame.setVisible(true);
    }
}