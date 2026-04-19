package lab3;

public class ReverseStringDemo {
	
	    public static String reverseString(String str) {
	        String reversed = "";

	        for (int i = str.length() - 1; i >= 0; i--) {
	            reversed += str.charAt(i);
	        }

	        return reversed;
	    }

	    public static void main(String[] args) {
	        String str = "Programming";

	        System.out.println("Original String: " + str);
	        System.out.println("Reversed String: " + reverseString(str));
	    }
	}

