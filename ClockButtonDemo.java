package lab4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClockButtonDemo implements ActionListener {




	    JFrame frame;
	    JButton digitalClockButton, hourGlassButton;
	    JLabel label;

	    public ClockButtonDemo() {

	        frame = new JFrame("Clock Button Demo");

	        ImageIcon digitalIcon = new ImageIcon("digital_clock.png");
	        ImageIcon hourGlassIcon = new ImageIcon("hour_glass.png");

	        digitalClockButton = new JButton("Digital Clock", digitalIcon);
	        hourGlassButton = new JButton("Hour Glass", hourGlassIcon);

	        label = new JLabel("Press any button");
	        label.setFont(new Font("Arial", Font.PLAIN, 20));

	        digitalClockButton.addActionListener(this);
	        hourGlassButton.addActionListener(this);

	        frame.setLayout(new FlowLayout());

	        frame.add(digitalClockButton);
	        frame.add(hourGlassButton);
	        frame.add(label);

	        frame.setSize(500, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }

	    public void actionPerformed(ActionEvent e) {

	        if (e.getSource() == digitalClockButton) {
	            label.setText("Digital Clock is pressed");
	        } else if (e.getSource() == hourGlassButton) {
	            label.setText("Hour Glass is pressed");
	        }
	    }

	    public static void main(String[] args) {
	        new ClockButtonDemo();
	    }
	
}
