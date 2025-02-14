package basic;

public class StringPrac {
    public static void main(String[] args) {
        String ss = new String("Hello World!");
        String s = "Hello World!";
        String s1 = "nope";
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(ss.hashCode());

        System.out.println(ss.intern() == s);
        String sss = ss.intern();
        System.out.println(sss == ss);
        System.out.println(ss.equals(sss));
//        Integer i = 10;
//        System.out.println(i.equals(10));
//        int j = 10;
//        System.out.println(i == j);

        //String s1 = "knowledge";
        String s2 = s1;
        s1 = s1.concat(" and knowledge ");
        s2 = new String(s1);
        System.out.println(s2);

        System.out.println(s1.charAt(0));
        System.out.println(s1.length());
        System.out.println(s1.substring(0, 5));
        System.out.println(s1.indexOf("knowledge"));
        System.out.println(s1.indexOf("knowledge", 10));
        System.out.println(s1.lastIndexOf("knowledge"));
        System.out.println(s1.equals(s2)); //value
        System.out.println(s1 == s2); // reference
        System.out.println(s1.compareTo(s2)); // check ascii if it is same then return 0


        String str1 = "feeksforfeeks";
        System.out.println("Original String " + str1);
        String str2 = "feeksforfeeks".replace('f' ,'g') ;
        System.out.println("Replaced f with g -> " + str2);

        System.out.println("*********************");


        String x = "something";
        String y = "something";
        String xx = new String("Hello World!");
        String yy = "Hello World!";
        if (yy.equals(xx)) {
            System.out.println("wonderful");
        }
        else
        {
            System.out.println("Sad life");
        }

        if(x == y)
        {
            System.out.println("wonderful");
        }
        else
        {
            System.out.println("Sad life");
        }

        if(xx.intern() == yy)
        {
            System.out.println("wonderful");
        }
        else {
            System.out.println("Sad life");
        }

        System.out.println(x.hashCode());
        System.out.println(y.hashCode());
        System.out.println(xx.hashCode());
        System.out.println(yy.hashCode());

    }
}
