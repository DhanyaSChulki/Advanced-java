package lab3;
import java.util.Random;
public class RandomStringDemo {
	

	    public static String generateRandomString(int length) {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        String result = "";

	        Random random = new Random();

	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length());
	            result += characters.charAt(index);
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        int length = 8;

	        System.out.println("Random String: " + generateRandomString(length));
	    }
	}

