
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class LandingPageManager {

	public JFrame landingPageFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingPageManager window = new LandingPageManager();
					window.landingPageFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LandingPageManager() {
		initialize();
	}
	public JFrame getFrame() {
		return this.landingPageFrame;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		landingPageFrame = new JFrame();
		landingPageFrame.getContentPane().setBackground(Color.WHITE);
		landingPageFrame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel landingPage = new JPanel();
		landingPageFrame.getContentPane().add(landingPage, "landingPage");
		landingPage.setLayout(null);
		
		JButton manageParkingButton = new JButton("MANAGE PARKING");
		manageParkingButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		manageParkingButton.setBackground(new Color(204, 204, 153));
		manageParkingButton.setBounds(66, 227, 250, 89);
		landingPage.add(manageParkingButton);
		
		JButton logOutButton = new JButton("ADD PAYMENT METHOD");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String paymentMethod = JOptionPane.showInputDialog("Name of Payment Method?", null);
			}
		});
		logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
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
		landingPageFrame.setBounds(100, 100, 800, 570);
		landingPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		// Manage Parking Button Listener
		manageParkingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageParkingLot parkingLotFrame= new manageParkingLot();
				parkingLotFrame.setVisible(true);
				landingPageFrame.setVisible(false);
			}
		});
		
		
		// Validate Accounts Button Listener
		ValidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateAccounts newFrame = new validateAccounts();
				newFrame.setVisible(true);
				landingPageFrame.setVisible(false);
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
	public void setVisible(boolean b) {
		this.landingPageFrame.setVisible(b);
	}
}
