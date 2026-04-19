package lab3;

public class NullOrEmptyCheck {
	
	    public static boolean isNullOrEmpty(String str) {
	        return str == null || str.trim().isEmpty();
	    }

	    public static void main(String[] args) {
	        String str = "   ";

	        System.out.println("String: '" + str + "'");
	        System.out.println("Is Null or Empty: " + isNullOrEmpty(str));
	    }
	}

