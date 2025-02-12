package basic;

public class MainClass {

    private static long depth=0L;

    public static void main(String[] args){
        deep();
    }

    private static void deep(){
        System.err.println(++depth);
        deep();
    }

}

//13033
//12955