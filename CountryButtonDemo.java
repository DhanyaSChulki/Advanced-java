package lab4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CountryButtonDemo implements ActionListener  {
	

	    JFrame frame;
	    JButton indiaButton, srilankaButton;
	    JLabel label;

	    public CountryButtonDemo() {

	        frame = new JFrame("Country Button Demo");

	        indiaButton = new JButton("India");
	        srilankaButton = new JButton("Srilanka");

	        label = new JLabel("Press a button");
	        label.setFont(new Font("Arial", Font.PLAIN, 20));

	        indiaButton.addActionListener(this);
	        srilankaButton.addActionListener(this);

	        frame.setLayout(new FlowLayout());

	        frame.add(indiaButton);
	        frame.add(srilankaButton);
	        frame.add(label);

	        frame.setSize(400, 200);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }

	    public void actionPerformed(ActionEvent e) {

	        if (e.getSource() == indiaButton) {
	            label.setText("India is pressed");
	        } else if (e.getSource() == srilankaButton) {
	            label.setText("Srilanka is pressed");
	        }
	    }

	    public static void main(String[] args) {
	        new CountryButtonDemo();
	    }
	
}
