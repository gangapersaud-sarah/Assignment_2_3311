import javax.swing.JButton;
import javax.swing.JFrame;

public class System {
    public System() {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setVisible(true);

        JButton button = new JButton();
        button.setBounds(490, 155, 89, 23);
        frame.getContentPane().add(button);
    }

    public static void main(String args[]) {
        new System();
    }
}


