package collection.and.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;

public class IteratorDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");


//        Iterator<String> iterator = list.iterator();
//        Iterator<String> iterator2 = list.iterator();
//        while (iterator.hasNext() && iterator2.hasNext()) {
//            System.out.println(iterator.next());
//            System.out.println(iterator2.next());
//            iterator.remove();
//        }

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("A", "B");
        map.put("B", "C");
        map.put("C", "D");
        Iterator<String> iterator = map.values().iterator();
        Iterator<String> iterator2 = map.values().iterator();
        while (iterator.hasNext() && iterator2.hasNext()) {
            String value = iterator.next();
            String value1 = iterator2.next();
            System.out.println(value);
//            map.put(value, value);
            iterator.remove();
        }
        System.out.println(map.entrySet());

        List<String> list = new ArrayList<>();
        list.add("Jane");
        list.add("Heidi");
        list.add("Hannah");

        ListIterator<String> listIterator = list.listIterator();

//        while(listIterator.hasNext()) {
//            System.out.println(listIterator.next());
//        }

        while(listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
