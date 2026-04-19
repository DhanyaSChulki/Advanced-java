package lab3;

public class RemoveWhitespaceDemo {
	
	    public static String removeWhitespace(String str) {
	        return str.replaceAll("\\s+", "");
	    }

	    public static void main(String[] args) {
	        String str = "Java Programming Language";

	        System.out.println("Original String: " + str);
	        System.out.println("After Removing Whitespaces: " + removeWhitespace(str));
	    }
	}

