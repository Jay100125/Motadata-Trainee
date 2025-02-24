//import java.io.IOException;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//     public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//         try{
//             System.out.println("Hello");
//         }catch(Exception e)
//         {
//             System.out.println("Exception");
//         }
//    }
//}
import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.util.*;


class parentttt
{
    static  void func(){

    }
}

class childdd extends parentttt
{
    static void func()
    {

    }
}

public class Main

{
   static int age = 10;
   static Main main = new Main();
   final static String name = "james";

   Main()
   {
       System.out.println(age);
       System.out.println();
   }

    public static void main(String [] args)

    {
        parentttt p = new parentttt();
        parentttt p1 = new childdd();
        p1.func();

        Scanner sc = new Scanner(System.in);
//
//        int a = sc.nextInt();
//
//        String b = sc.nextLine();
//
//        System.out.printf("number is : "+ a + "and String is : " + b);

//        final int b = 0;
//

//            try{
//                throw new FileNotFoundException("adnj")
//            }
//            catch(Exception e)
//            {
//                System.out.println(e);
//            }

        int i = 2;
        float j = 5.6f;

//        float b = a;
        double a = 10;

//        System.out.println(b);

//        System.out.println(sum);

        System.out.println(age);
        System.out.println(name);

    }

}
