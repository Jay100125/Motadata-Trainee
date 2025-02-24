package collection.and.datastructure;

import java.util.*;


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

        // this throw unsupported operation exception
         unmodifiableList.addAll(ll);


    }
}
