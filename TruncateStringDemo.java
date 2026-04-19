package lab3;

public class TruncateStringDemo {


	    public static String truncate(String str, int maxLength) {
	        if (str.length() <= maxLength) {
	            return str;
	        }

	        return str.substring(0, maxLength) + "...";
	    }

	    public static void main(String[] args) {
	        String str = "Java Programming Language";
	        int maxLength = 10;

	        System.out.println("Original String: " + str);
	        System.out.println("Truncated String: " + truncate(str, maxLength));
	    }
	}

