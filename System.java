import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class System {
    public System() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
		frame.setBounds(100, 100, 451, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextField textField = new JTextField();
        textField.setVisible(true);
		textField.setBounds(94, 71, 165, 19);
		frame.getContentPane().add(textField);
		
		JTextField textField_1 = new JTextField();
        textField_1.setVisible(true);
		textField_1.setBounds(94, 143, 165, 19);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(94, 194, 165, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Enter");
        btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
				String password = textField_1.getText();
				lblNewLabel.setText(userName + " " + password);
			}
		});
		btnNewButton.setBounds(295, 108, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
    }

    public static void main(String args[]) {
        new System();
    }
}


