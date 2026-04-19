package lab2a;

public class StringPerformanceTest {
	
	    public static void main(String[] args) {

	        int count = 10000;

	        // Performance test using StringBuffer
	        StringBuffer stringBuffer = new StringBuffer();
	        long startBuffer = System.nanoTime();

	        for (int i = 0; i < count; i++) {
	            stringBuffer.append("AIET");
	        }

	        long endBuffer = System.nanoTime();
	        long bufferTime = endBuffer - startBuffer;

	        // Performance test using StringBuilder
	        StringBuilder stringBuilder = new StringBuilder();
	        long startBuilder = System.nanoTime();

	        for (int i = 0; i < count; i++) {
	            stringBuilder.append("AIET");
	        }

	        long endBuilder = System.nanoTime();
	        long builderTime = endBuilder - startBuilder;

	        // Display results
	        System.out.println("StringBuffer Time: " + bufferTime + " ns");
	        System.out.println("StringBuilder Time: " + builderTime + " ns");

	        // Compare performance
	        if (bufferTime > builderTime) {
	            System.out.println("StringBuilder is faster than StringBuffer.");
	        } else if (builderTime > bufferTime) {
	            System.out.println("StringBuffer is faster than StringBuilder.");
	        } else {
	            System.out.println("Both have equal performance.");
	        }
	    }
	}
