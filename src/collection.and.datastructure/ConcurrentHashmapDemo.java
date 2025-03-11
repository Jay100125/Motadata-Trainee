package collection.and.datastructure;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashmapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
//        map.put(null, "one");
//        map.get()


        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(null, "two");

        System.out.println(map2.get(null));
    }
}
