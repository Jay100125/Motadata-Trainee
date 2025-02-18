package test.testing;

public class passby {
    void passBY(int a)
    {
        a = 20;
    }
    public static void main(String[] args) {
        int i = 10;
        System.out.println(i);
        passby p = new passby();
        p.passBY(i);
        System.out.println(i);

        String s1 = new String("one");
        String s2 = new String("one");
        String s3 = s1.intern();
        String s4 = s2.intern();

        System.out.println(s3 == s4);

//        int a = 10;
//        final int b = 20;
//        switch (a)
//        {
//            case 10:break;
//            case b:break;
//        }

        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);

        Integer e = 135;
        Integer f = 135;
        System.out.println(e == f);

        int[] arr = {1,2,3,4,5};

        try{
            int x = arr[arr.length]/0;
        }catch(NumberFormatException err)
        {
            System.out.println("This is number format exception");
        }
        catch(ArithmeticException err)
        {
            System.out.println("Arithmetic exception");
        }
        catch(ArrayIndexOutOfBoundsException err)
        {
            System.out.println("ArrayIndexOutOfBoundsException");
        }
        catch(Exception err)
        {
            System.out.println("Exception");
        }
        finally
        {
            System.out.println("finally");
        }


    }
}
