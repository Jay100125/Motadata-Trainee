public class DataTypes {

     DataTypes(){

    }
    public static int execute(int a, int b){
        try{
            return a + b;
        }
        catch(Exception ignore)
        {
            return 100;
        }
        finally{
            System.out.println("this will not execute");
            return 200;
        }
    }
    public static void main(String[] args) {
//       final boolean flag = false;
//
//       while(flag){
//           System.out.println();
//       }



        Boolean b1= Boolean.getBoolean("true");
        Boolean b2= Boolean.getBoolean("FalSe");
        Boolean b3= Boolean.getBoolean("abc");
        Boolean b4= null;
        System.out.println(""+b1+b2+b3+b4);
        System.out.println(b1);

        byte b = 126;
        System.out.println(b);

//        int a = b + 1;
//        b = (byte)b+1   ;
//        b = b++;
//        System.out.println(b);
//        System.out.println(a);

    }
}
