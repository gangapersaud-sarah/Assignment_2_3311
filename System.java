import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JButton;

public class System {
    public System() {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setVisible(true);

        JButton button = new JButton("New Button");
        button.setBounds(490, 155, 89, 23);
        frame.getContentPane().add(BorderLayout.NORTH, button);
    }

    public static void main(String args[]) {
        new System();
    }
}


