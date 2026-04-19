package lab3;

public class CountOccurrencesDemo {
	
	    public static int countOccurrences(String mainString, String subString) {
	        int count = 0;
	        int index = 0;

	        while ((index = mainString.indexOf(subString, index)) != -1) {
	            count++;
	            index += subString.length();
	        }

	        return count;
	    }

	    public static void main(String[] args) {
	        String mainString = "Java is easy. Java is powerful. Java is popular.";
	        String subString = "Java";

	        System.out.println("Main String: " + mainString);
	        System.out.println("Substring: " + subString);
	        System.out.println("Occurrences: " + countOccurrences(mainString, subString));
	    }
	}

