package extra;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

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
        LinkedHashMap<Integer, String> hm = new LinkedHashMap<>();
        hm.put(1, "one");
        hm.put(2, "two");
        hm.put(3, "three");
        hm.put(4, "four");

        for(Map.Entry<Integer, String> entry : hm.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("_______________________");
        System.out.println(hm.put(1, "One"));
        System.out.println("_______________________");

        for(Map.Entry<Integer, String> entry : hm.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Banana", 3);
        hashMap.put("Apple", 1);
        hashMap.put("Cherry", 2);
        hashMap.put("Date", 4);

        // Creating a LinkedHashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Banana", 3);
        linkedHashMap.put("Apple", 1);
        linkedHashMap.put("Cherry", 2);
        linkedHashMap.put("Date", 4);

        // Printing both maps
        System.out.println("HashMap (Unordered): " + hashMap);
        System.out.println("LinkedHashMap (Insertion Order Maintained): " + linkedHashMap);


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(11);
        pq.add(32);
        pq.add(33);
        pq.add(4);
        pq.add(5);

        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }

        CopyOnWriteArrayList<Integer> cpa = new CopyOnWriteArrayList<>();
        cpa.add(1);
        cpa.add(2);
        cpa.add(3);
        cpa.add(4);

        Iterator<Integer> iterator2 = cpa.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
            cpa.add(99);
        }

        System.out.println(cpa);

        ArrayList<Integer> cpa2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        cpa2.add(1);
        cpa2.add(2);
        cpa2.add(3);
        cpa2.add(4);
        cpa2.add(5);

        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        System.out.println(cpa.get(9));

        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;






    }
}
