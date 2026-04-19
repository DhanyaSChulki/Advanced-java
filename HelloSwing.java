package lab4;

import javax.swing.*;
import java.awt.*;

public class HelloSwing {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Swing Hello Program");

        JLabel label = new JLabel("Hello! VI C , Welcome to Swing Programming");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Arial", Font.PLAIN, 32));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(label);

        frame.setSize(900, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}