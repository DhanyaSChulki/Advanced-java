package lab5;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ColorTabbedPane {
	
	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Color Tabbed Pane");
	        frame.setSize(400, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JTabbedPane tabbedPane = new JTabbedPane();

	        JPanel cyanPanel = new JPanel();
	        cyanPanel.setBackground(Color.CYAN);

	        JPanel magentaPanel = new JPanel();
	        magentaPanel.setBackground(Color.MAGENTA);

	        JPanel yellowPanel = new JPanel();
	        yellowPanel.setBackground(Color.YELLOW);

	        tabbedPane.addTab("Cyan", cyanPanel);
	        tabbedPane.addTab("Magenta", magentaPanel);
	        tabbedPane.addTab("Yellow", yellowPanel);

	        tabbedPane.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
	                int index = tabbedPane.getSelectedIndex();
	                String color = tabbedPane.getTitleAt(index);
	                System.out.println("Selected Color: " + color);
	            }
	        });

	        frame.add(tabbedPane);
	        frame.setVisible(true);
	    }
	
}
