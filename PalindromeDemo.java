package lab3;

public class PalindromeDemo {
	

	    public static String reverseString(String str) {
	        String reversed = "";

	        for (int i = str.length() - 1; i >= 0; i--) {
	            reversed += str.charAt(i);
	        }

	        return reversed;
	    }

	    public static boolean isPalindrome(String str) {
	        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	        String reversed = reverseString(cleaned);

	        return cleaned.equals(reversed);
	    }

	    public static void main(String[] args) {
	        String str = "A man, a plan, a canal: Panama";

	        System.out.println("String: " + str);
	        System.out.println("Is Palindrome: " + isPalindrome(str));
	    }
	
}
