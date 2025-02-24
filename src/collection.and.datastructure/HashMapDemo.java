package collection.and.datastructure;


import java.util.*;

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

        System.out.println("-----------------------------------------------------");

        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("one", 1);
        sortedMap.put("two", 2);
        sortedMap.put("three", 3);

        System.out.println(sortedMap);

        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());

    }
}
