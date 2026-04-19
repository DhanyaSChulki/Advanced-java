package lab2a;
import java.util.Arrays;

public class StringOperationsDemo {
	
	    public static void main(String[] args) {

	        // 1. String Creation and Basic Operations
	        String str1 = "Hello";
	        String str2 = new String("World");

	        System.out.println("String 1: " + str1);
	        System.out.println("String 2: " + str2);

	        // 2. Length and Character Access
	        System.out.println("\nLength of str1: " + str1.length());
	        System.out.println("Character at index 1 in str1: " + str1.charAt(1));

	        // 3. String Comparison
	        String a = "Java";
	        String b = "java";

	        System.out.println("\nUsing equals(): " + a.equals(b));
	        System.out.println("Using equalsIgnoreCase(): " + a.equalsIgnoreCase(b));
	        System.out.println("Using compareTo(): " + a.compareTo(b));

	        // 4. String Searching
	        String sentence = "Java programming is easy";

	        System.out.println("\nContains 'programming': " + sentence.contains("programming"));
	        System.out.println("Index of 'is': " + sentence.indexOf("is"));
	        System.out.println("Last index of 'a': " + sentence.lastIndexOf("a"));

	        // 5. Substring Operations
	        String text = "WelcomeToJava";

	        System.out.println("\nSubstring from index 7: " + text.substring(7));
	        System.out.println("Substring from index 0 to 7: " + text.substring(0, 7));

	        // 6. String Modification
	        String name = "Java Programming";

	        System.out.println("\nUppercase: " + name.toUpperCase());
	        System.out.println("Lowercase: " + name.toLowerCase());
	        System.out.println("Replace Java with Python: " + name.replace("Java", "Python"));

	        // 7. Whitespace Handling
	        String spacedText = "   Hello Java   ";

	        System.out.println("\nOriginal String: '" + spacedText + "'");
	        System.out.println("Trimmed String: '" + spacedText.trim() + "'");

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

	        System.out.println("\nAfter splitting:");
	        System.out.println(Arrays.toString(fruitArray));

	        // 10. StringBuilder Demo
	        StringBuilder sb = new StringBuilder("Java");

	        sb.append(" Programming");
	        sb.insert(5, "Language ");
	        sb.replace(0, 4, "Advanced Java");
	        sb.delete(9, 14);

	        System.out.println("\nStringBuilder Result: " + sb);

	        // 11. String Formatting
	        String studentName = "Dhanya";
	        int marks = 95;

	        String result = String.format("Student Name: %s, Marks: %d", studentName, marks);

	        System.out.println("\nFormatted String:");
	        System.out.println(result);

	        // 12. Validate Email with contains(), startsWith() and endsWith()
	        String email = "dhanya123@gmail.com";

	        boolean isValid = email.contains("@") &&
	                          email.contains(".") &&
	                          !email.startsWith("@") &&
	                          !email.endsWith(".") &&
	                          (email.endsWith(".com") || email.endsWith(".in"));

	        System.out.println("\nEmail: " + email);
	        System.out.println("Is email valid? " + isValid);
	    }
	
}
