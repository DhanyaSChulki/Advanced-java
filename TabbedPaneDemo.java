package lab5;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
public class TabbedPaneDemo {
	

	    public static void main(String[] args) {

	        JFrame frame = new JFrame("Tabbed Pane Demo");

	        JTabbedPane tabbedPane = new JTabbedPane();

	        JPanel redPanel = new JPanel();
	        redPanel.setBackground(Color.RED);

	        JPanel bluePanel = new JPanel();
	        bluePanel.setBackground(Color.BLUE);

	        JPanel greenPanel = new JPanel();
	        greenPanel.setBackground(Color.GREEN);

	        tabbedPane.addTab("RED", redPanel);
	        tabbedPane.addTab("BLUE", bluePanel);
	        tabbedPane.addTab("GREEN", greenPanel);

	        JLabel label = new JLabel("RED Tab Selected", SwingConstants.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 18));

	        tabbedPane.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {

	                int index = tabbedPane.getSelectedIndex();
	                String tabName = tabbedPane.getTitleAt(index);

	                label.setText(tabName + " Tab Selected");
	            }
	        });

	        frame.setLayout(new BorderLayout());
	        frame.add(tabbedPane, BorderLayout.CENTER);
	        frame.add(label, BorderLayout.SOUTH);

	        frame.setSize(400, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }
	}

