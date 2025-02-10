package basic;

public class BlockScope {
    public static void main(String[] args) {
                // local variable declared
                int i = 5;

                // for loop variable declared
//                for (int a = 0; a < 5; a++)// error : variable a is already defined in method main
//                {
//                    System.out.println(a);
//                }

        int x;
        for (x = 0; x < 4; x++) {
            System.out.print(x + " ");
        }
        System.out.println();
        int a = 20, b = 10, c = 0;

        // a=b+++c is compiled as
        // b++ +c
        // a=b+c then b=b+1
        a = b+++c;
        System.out.println(a);
        System.out.println(b);

        int p = 5, q = 8;

        // concatenates x and y as
        // first x is added to "concatenation (x+y) = "
        // producing "concatenation (x+y) = 5"
        // and then 8 is further concatenated.
        System.out.println("Concatenation (x+y) = " + p + q);

        // addition of x and y
        System.out.println("Addition (x+y) = " + (p + q));
    }
}
