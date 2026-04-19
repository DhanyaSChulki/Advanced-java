package lab5;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
public class CountryListDemo {
	

	    public static void main(String[] args) {

	        JFrame frame = new JFrame("Country List Demo");

	        String[] countries = {
	            "USA", "India", "Vietnam", "Canada", "Denmark",
	            "France", "Great Britain", "Japan", "Africa",
	            "Greenland", "Singapore"
	        };

	        JList<String> countryList = new JList<>(countries);

	        countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	        countryList.addListSelectionListener(new ListSelectionListener() {
	            public void valueChanged(ListSelectionEvent e) {

	                if (!e.getValueIsAdjusting()) {
	                    String selectedCountry = countryList.getSelectedValue();
	                    System.out.println(selectedCountry + " is selected");
	                }
	            }
	        });

	        JScrollPane scrollPane = new JScrollPane(countryList);

	        frame.add(scrollPane, BorderLayout.CENTER);

	        frame.setSize(300, 250);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }
	
}
