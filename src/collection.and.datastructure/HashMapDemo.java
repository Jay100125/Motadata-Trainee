package collection.and.datastructure;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Person {

    long id;
    String name;
    LocalDate dateOfBirth;

    public Person(long id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.putIfAbsent(1, "One");
        map.getOrDefault(1, "Nope");
        System.out.println(map.get(1));

        System.out.println(map);
        System.out.println(map.get(22)); // null
        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("two"));

        System.out.println("----------------------------------------------");
        for(int i : map.keySet()) {
            System.out.println(map.get(i));
        }

        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        LinkedHashMap<String , Integer> mpp =  new LinkedHashMap<>();
        mpp.put("one", 1);
        mpp.put("two", 2);
        mpp.put("three", 3);

        for(Map.Entry<String, Integer> entry : mpp.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Iterator<Map.Entry<String, Integer>> iterator = mpp.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("-----------------------------------------------------");

        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("one", 1);
        sortedMap.put("two", 2);
        sortedMap.put("three", 3);

        System.out.println(sortedMap);

        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());


//        IdentityHashMap<String , Integer> identityMap = new IdentityHashMap<>();


        // shallow copy on map
        HashMap<Integer, Person> personMap = new HashMap<>();

        personMap.put(1, new Person(1l, "Alex", LocalDate.of(1990, 01, 01)));
        personMap.put(2, new Person(2l, "Bob", LocalDate.of(1990, 02, 01)));

        HashMap<Integer, Person> clonedMap = (HashMap<Integer, Person>) personMap.clone();
        System.out.println(clonedMap.get(1).getName());
        clonedMap.get(1).setName("Charles");

        System.out.println(clonedMap.get(1).getName());
        System.out.println(personMap.get(1).getName());



        Map<Integer, Person> clonedMapWithStream = personMap.entrySet()
                .stream()
                //perform customization
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(clonedMapWithStream.get(1).getName());
        clonedMapWithStream.get(1).setName("cherry");
        System.out.println(clonedMapWithStream.get(1).getName());
        System.out.println(personMap.get(1).getName());


        HashSet<Integer> set = new HashSet<>();

    }
}
