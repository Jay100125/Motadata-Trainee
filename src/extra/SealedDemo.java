package extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

sealed class A {
    int a = 110;
}
non-sealed class b extends A{
    int b =10;
}

class c extends b{

}
public class SealedDemo {
    public static void main(String[] args) {
        b bb = new b();
        System.out.println(bb.a);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        for(Integer i : list){
            System.out.println(i);
        }

        Iterator<Integer> iterator1 = list.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());

        }
        list.remove((Integer) 3);
        System.out.println(list);


        ArrayList<Integer> ll1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        ll1.add(1);
        ll1.add(2);

        System.out.println(ll1);

        List<Integer> ll2 = ll1.subList(2,4);

        System.out.println(ll2);
        ll2.add(30);
        System.out.println(ll2);
        System.out.println(ll1);

//        String[] stringArray = {"a", "b", "c"};
//
//// Creating List using Arrays.asList() method
//        List<String> listofStrings = Arrays.asList(stringArray);
//// Printing class name
//        System.out.println(listofStrings.getClass().getCanonicalName());
//        listofStrings.add("d");
//        System.out.println(listofStrings);

//        String[] stringArray = {"a", "b", "c"};
//
//// Creating List using new ArrayList()
//        List<String> listofStrings = new ArrayList<>(Arrays.asList(stringArray));
//
//// Printing class name
//        System.out.println(listofStrings.getClass().getCanonicalName());      // java.util.ArrayList
//
//        listofStrings.add("d");
//        System.out.println(listofStrings);
//        List<Integer> numbers = List.of(1, 2,-5,- 3, 4, 5);
//        Iterator<Integer> iterator = numbers.iterator();
//
//        while(iterator.hasNext()) {
//            iterator.forEachRemaining(System.out::println);
//            //1 2 3 4 5
//            iterator.forEachRemaining(Math::abs);
//        }
//
//        System.out.println(numbers);

    }
}
