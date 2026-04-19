package lab3;
import java.util.Arrays;
public class StringFunctionsDemo {
	
	    public static void main(String[] args) {

	        // 1. String Creation and Basic Operations
	        String str1 = "Hello";
	        String str2 = new String("Java");

	        System.out.println("String 1: " + str1);
	        System.out.println("String 2: " + str2);

	        // 2. Length and Character Access
	        System.out.println("\nLength of str1: " + str1.length());
	        System.out.println("Character at index 1 of str1: " + str1.charAt(1));

	        // 3. String Comparison
	        String s1 = "Java";
	        String s2 = "java";

	        System.out.println("\nUsing equals(): " + s1.equals(s2));
	        System.out.println("Using equalsIgnoreCase(): " + s1.equalsIgnoreCase(s2));
	        System.out.println("Using compareTo(): " + s1.compareTo(s2));

	        // 4. String Searching
	        String text = "Java programming language";

	        System.out.println("\nContains 'programming': " + text.contains("programming"));
	        System.out.println("Index of 'language': " + text.indexOf("language"));
	        System.out.println("Last index of 'a': " + text.lastIndexOf('a'));

	        // 5. Substring Operations
	        String word = "ComputerScience";

	        System.out.println("\nSubstring from index 8: " + word.substring(8));
	        System.out.println("Substring from index 0 to 8: " + word.substring(0, 8));

	        // 6. String Modification
	        String msg = "Java Language";

	        System.out.println("\nUppercase: " + msg.toUpperCase());
	        System.out.println("Lowercase: " + msg.toLowerCase());
	        System.out.println("Replace Java with Python: " + msg.replace("Java", "Python"));

	        // 7. Whitespace Handling
	        String spaced = "   Welcome to Java   ";

	        System.out.println("\nOriginal String: '" + spaced + "'");
	        System.out.println("Trimmed String: '" + spaced.trim() + "'");

	        // 8. String Concatenation
	        String firstName = "Dhanya";
	        String lastName = "Chulki";

	        String fullName1 = firstName + " " + lastName;
	        String fullName2 = firstName.concat(" ").concat(lastName);

	        System.out.println("\nUsing + operator: " + fullName1);
	        System.out.println("Using concat(): " + fullName2);

	        // 9. String Splitting
	        String fruits = "Apple,Banana,Mango,Orange";

	        String[] fruitArray = fruits.split(",");

	        System.out.println("\nAfter Splitting:");
	        System.out.println(Arrays.toString(fruitArray));

	        // 10. StringBuilder Demo
	        StringBuilder sb = new StringBuilder("Java");

	        sb.append(" Programming");
	        sb.insert(5, "Language ");
	        sb.replace(0, 4, "Advanced Java");
	        sb.delete(9, 14);

	        System.out.println("\nStringBuilder Result: " + sb);

	        // 11. String Formatting
	        String name = "Dhanya";
	        int marks = 95;

	        String formatted = String.format("Student Name: %s, Marks: %d", name, marks);

	        System.out.println("\nFormatted String:");
	        System.out.println(formatted);

	        // 12. Email Validation
	        String email = "dhanya@gmail.com";

	        boolean validEmail = email.contains("@") &&
	                             email.contains(".") &&
	                             !email.startsWith("@") &&
	                             !email.endsWith(".") &&
	                             (email.endsWith(".com") || email.endsWith(".in"));

	        System.out.println("\nEmail: " + email);
	        System.out.println("Is Email Valid? " + validEmail);
	    }
	
}
