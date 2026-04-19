package lab3;

public class NumericCheckDemo {


	    public static boolean isNumeric(String str) {
	        if (str == null || str.isEmpty()) {
	            return false;
	        }

	        for (int i = 0; i < str.length(); i++) {
	            if (!Character.isDigit(str.charAt(i))) {
	                return false;
	            }
	        }

	        return true;
	    }

	    public static void main(String[] args) {
	        String str = "123456";

	        System.out.println("String: " + str);
	        System.out.println("Is Numeric: " + isNumeric(str));
	    }
	}

