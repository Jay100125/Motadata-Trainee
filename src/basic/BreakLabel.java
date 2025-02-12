package basic;

public class BreakLabel {

    public static void main(String[] args) {

        boolean t = true;

        // label first
        first: {
            second: {
                third: {
                    System.out.println("Before break statement");

                    if (t) {
                        break second;  // Exits the second label block
                    }

                    System.out.println("This won't execute.");
                }
                System.out.println("This won't execute.");
            }
            System.out.println("After second block.");
        }
    }
}
