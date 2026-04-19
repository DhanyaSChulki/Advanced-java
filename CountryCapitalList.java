package lab5;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.HashMap;

public class CountryCapitalList {
	
	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Country List");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(300, 300);

	        String[] countries = {
	            "USA", "India", "Vietnam", "Canada", "Denmark",
	            "France", "Great Britain", "Japan", "Africa",
	            "Greenland", "Singapore"
	        };

	        HashMap<String, String> capitalMap = new HashMap<>();
	        capitalMap.put("USA", "Washington, D.C.");
	        capitalMap.put("India", "New Delhi");
	        capitalMap.put("Vietnam", "Hanoi");
	        capitalMap.put("Canada", "Ottawa");
	        capitalMap.put("Denmark", "Copenhagen");
	        capitalMap.put("France", "Paris");
	        capitalMap.put("Great Britain", "London");
	        capitalMap.put("Japan", "Tokyo");
	        capitalMap.put("Africa", "No single capital");
	        capitalMap.put("Greenland", "Nuuk");
	        capitalMap.put("Singapore", "Singapore");

	        JList<String> countryList = new JList<>(countries);
	        countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	        countryList.addListSelectionListener(new ListSelectionListener() {
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                    String selectedCountry = countryList.getSelectedValue();
	                    String capital = capitalMap.get(selectedCountry);
	                    System.out.println("Country: " + selectedCountry + " | Capital: " + capital);
	                }
	            }
	        });

	        JScrollPane scrollPane = new JScrollPane(countryList);

	        frame.add(scrollPane, BorderLayout.CENTER);
	        frame.setVisible(true);
	    }
	
}
