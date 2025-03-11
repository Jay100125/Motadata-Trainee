package collection.and.datastructure;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class ListDemo {
    public static void main(String[] args) {
        List<String> ll = new ArrayList<>();
        ArrayList<String> ss = new ArrayList<>();
        ArrayList<String> ss2 = new ArrayList<>();
        ss.add("a");
        ss.add("b");
        ss.add("c");
        ss.add("a");

        ll.add("A");
        ll.add("B");
        ll.add("C");
        ll.add("c");
        ll.add("a");

        ll.addAll(ss);
        System.out.println(ll);
        System.out.println(ll.size()); // 3
        System.out.println(ll.get(0)); // A

        System.out.println(ll.isEmpty()); // false
        System.out.println(ss2.isEmpty()); // true
        System.out.println(ss2.size()); // 0
        System.out.println(ss.contains("X")); // false
        System.out.println(ss2.indexOf("X")); // -1
        System.out.println(ss.indexOf("a")); // 0
        System.out.println(ss.lastIndexOf("a")); // 3

        ArrayList<?> ssClone = (ArrayList<?>) ss.clone();
        System.out.println(ssClone);

        // hashcode is same but still return false on ==
        System.out.println(ss == ssClone);
        System.out.println(ss.equals(ssClone));
        System.out.println(ss.hashCode() == ssClone.hashCode());
        System.out.println(ss.hashCode());
        System.out.println(ssClone.hashCode());

        Object[] toar = ss.toArray();
        for(Object s : toar) {
            System.out.println(s);
        }

        System.out.println(ss.get(0));
        System.out.println("______________________-");
        System.out.println(ss.set(0, "d"));
        System.out.println("______________________-");


        System.out.println(ss.add("J"));

        System.out.println(ss.remove(0));
        System.out.println(ss);
//
//        ss2.clear();
//        System.out.println(ss2);
//        System.out.println(ss2.size());

        System.out.println(ss.size());
        System.out.println(ss);
        System.out.println(ss.addAll(2,ss));
        System.out.println(ss);

//       Collections.sort(ss);
//        ss.sort(null)
//        ;
        ss.sort(Comparator.naturalOrder());
        ss.sort(Comparator.reverseOrder());
        System.out.println(ss);
        System.out.println(ll);
        System.out.println(ll.retainAll(ss));
        System.out.println(ll);
//        System.out.println(ss2.get(0));


        List<String> ssSubList = ss.subList(0,2);
        System.out.println(ssSubList);

        // remove all element

        System.out.println(ll.removeIf(s -> s.contains("c")));
        ll.forEach(System.out::println);

        // increasing capacity.. don't size
        ss.ensureCapacity(100);
        System.out.println(ss);
        System.out.println(ss.size());

        ss.trimToSize();
        ss.replaceAll(x -> x.toUpperCase());
        System.out.println(ss);


            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee(1, "A"));
            emps.add(new Employee(2, "B"));
            emps.add(new Employee(3, "C"));
            emps.add(new Employee(4, "D"));

        System.out.println(emps.contains(new Employee(5, "A")));
        System.out.println(emps.contains(new Employee(2,"B")));
        System.out.println(emps.indexOf(new Employee(5, "A")));
        System.out.println(emps.lastIndexOf(new Employee(2, "B")));


        List<String> names = new ArrayList<>();
        names.add("Jay");
        names.add("Bob");
        names.add("James");
        names.add("Jeet");

        names.sort(new Comparator<String>() {
            public int compare (String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(names);

        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // start from the end of the list and traverse backwards.
        ListIterator<String> lit = names.listIterator(names.size());
        while(lit.hasPrevious())
        {
            System.out.println(lit.previous());
        }

//        ll.removeIf(s -> s.equals("a"));

        // unmodifiableList

        List<String> unmodifiableList = Collections.unmodifiableList(ll);
        System.out.println(unmodifiableList);

        System.out.println("------------");
//        unmodifiableList.remove(1);
        System.out.println(unmodifiableList);

        // this throw unsupported operation exception
//         unmodifiableList.addAll(ll);
        System.out.println("---------");
        List<Integer> ll4 = new ArrayList<>();
        ll4.add(1);
        ll4.add(2);
        ll4.add(3);
        ll4.add(4);


        System.out.println(ll4);


        CopyOnWriteArrayList<Integer> cp = new CopyOnWriteArrayList<>();
        cp.add(1);
        cp.add(2);
        cp.add(3);

        Iterator<Integer> it4 = cp.iterator();
//        while(it4.hasNext()) {
////            System.out.println(it4.next());
////            it4.remove();
////            cp.add(4);
//        }
        System.out.println(cp);



        List<Integer> ll5 = new ArrayList<>();
        ll5.add(1);
        ll5.add(2);
        ll5.add(3);
        ll5.add(4);
        ll5.add(5);

        Enumeration<Integer> e = Collections.enumeration(ll5);
        while(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
            System.out.println("----------");
        }
//        for(Integer i : ll5) {
//            ll5.remove(i);
//        }

//        Iterator<Integer> it5 = ll5.iterator();
//        while(it5.hasNext()) {
////            System.out.println(it5.next());
////            ll5.remove(it5.next());
//        }
//        System.out.println(ll5);
//
//        HashMap<Integer, String>hh = new HashMap<>();

        System.out.println("@@@@@@@@@@");
        List<Integer> ll6 = new ArrayList<>();
        ll6.add(1);
        ll6.add(2);
        ll6.add(3);
        ll6.add(4);
        ll6.add(5);

//        for(int i = 0; i < ll6.size(); i++)
//        {
//            if(i == 2)
//            {
//                ll6.remove(i+1);
//            }
//        }

//        Iterator<Integer> it6 = ll6.iterator();
//        while(it6.hasNext())
//        {
//            ll6.remove(it6.next());
//        }
//        System.out.println(ll6);

    }
}
