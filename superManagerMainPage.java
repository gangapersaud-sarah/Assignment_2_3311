import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class superManagerMainPage extends JFrame {

	private static superManagerMainPage instance = null;
	private JPanel contentPane;
    JTextField txt_username = new JTextField();
    JTextField txt_password = new JTextField();
    JLabel lblNewLabel = new JLabel("");
    JButton btnNewButton = new JButton("Enter");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					superManagerMainPage frame = new superManagerMainPage();
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
	public superManagerMainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btn_create_auto = new JButton("Create Auto Account");
		btn_create_auto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//method called from System class that generates and returns
				contentPane.setVisible(false);
				createAutoAccount a2 = new createAutoAccount();
				a2.frame.setVisible(true);
				
			}
		});
		
		JButton btn_view_auto1 = new JButton("View auto accounts");
		btn_view_auto1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				try {
					viewAutoAccount frame = new viewAutoAccount();
					frame.setVisible(true);
				} catch (Exception a2) {
					a2.printStackTrace();
				}
			}
		});
		
		JButton btn_return = new JButton("return");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//method called from System class that generates and returns
				contentPane.setVisible(false);
				manager_medium c2 = new manager_medium();
				c2.frame.setVisible(true);
				
			}
		});
		
		btn_create_auto.setBounds(34, 108, 149, 21);
		contentPane.add(btn_create_auto);
		
		btn_view_auto1.setBounds(246, 107, 149, 22);
		contentPane.add(btn_view_auto1);
		
		btn_return.setBounds(10, 228, 89, 23);
		contentPane.add(btn_return);
		
		JLabel lbl_title = new JLabel("Super Manager Main Page");
		lbl_title.setBounds(144, 11, 214, 30);
		contentPane.add(lbl_title);	
		
    }


    // validate user email when user signs up
    public boolean authenticateEmail() {
        return true;
    }

    // validate user password when user signs up
    public boolean authenticatePassword() {
        return true;
    }
    
    public static superManagerMainPage getInstance(){
		if (instance == null){
			instance = new superManagerMainPage();
		}
		return instance;
	}
}