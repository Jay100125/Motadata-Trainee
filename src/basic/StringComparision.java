package basic;

import java.io.IOException;

public class StringComparision {
//    public static void main(String[] args) {
//        // Adjust the number of iterations based on your needs
//        int iterations = 10000;
//
//        // Test String
//        long startTime = System.currentTimeMillis();
//        String stringResult = testString(iterations);
//        long stringTime = System.currentTimeMillis() - startTime;
//        System.out.println("String time: " + stringTime + " ms");
//
//        // Test StringBuilder
//        startTime = System.currentTimeMillis();
//        String builderResult = testStringBuilder(iterations);
//        long builderTime = System.currentTimeMillis() - startTime;
//        System.out.println("StringBuilder time: " + builderTime + " ms");
//
//        // Test StringBuffer
//        startTime = System.currentTimeMillis();
//        String bufferResult = testStringBuffer(iterations);
//        long bufferTime = System.currentTimeMillis() - startTime;
//        System.out.println("StringBuffer time: " + bufferTime + " ms");
//
//        // Keep references to avoid premature GC (optional for VisualVM)
//        System.out.println("Results length: " + stringResult.length() + ", " +
//                builderResult.length() + ", " + bufferResult.length());
//    }
//
//    public static String testString(int iterations) {
//        String result = "";
//        for (int i = 0; i < iterations; i++) {
//            result += "test" + i + " "; // Concatenation creates new String objects
//        }
//        return result;
//    }
//
//    public static String testStringBuilder(int iterations) {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < iterations; i++) {
//            builder.append("test").append(i).append(" "); // Modifies in-place
//        }
//        return builder.toString();
//    }
//
//    public static String testStringBuffer(int iterations) {
//        StringBuffer buffer = new StringBuffer();
//        for (int i = 0; i < iterations; i++) {
//            buffer.append("test").append(i).append(" "); // Modifies in-place, synchronized
//        }
//        return buffer.toString();
//    }
static final int ITERATIONS = 100_000;

    public static void main(String[] args) throws IOException {
        System.out.println("Starting String Test... Press Enter to continue.");
        System.in.read();
        testString();

        System.out.println("\nStarting StringBuilder Test... Press Enter to continue.");
        System.in.read();
        testStringBuilder();

        System.out.println("\nStarting StringBuffer Test... Press Enter to continue.");
        System.in.read();
        testStringBuffer();

        System.out.println("\nAll tests done! Press Enter to exit.");
        System.in.read();
    }

    static void testString() {
        String str = "";
        for (int i = 0; i < ITERATIONS; i++) {
            str += i;  // Creates a new object on every iteration
        }
        System.out.println("String operation completed.");
    }

    static void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append(i);
        }
        System.out.println("StringBuilder operation completed.");
    }

    static void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append(i);
        }
        System.out.println("StringBuffer operation completed.");

    }
    }