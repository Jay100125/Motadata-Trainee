package multithreading;

import java.util.*;
import java.util.concurrent.*;

class Collections{

    private List<Integer> integerList = new ArrayList<>();
    private List<Integer> linkedList = new LinkedList<>();
    private List<Integer> stack = new Stack<>(); // Stack implements Vector class

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

    private HashSet<Integer> hashSet = new HashSet<>();
    private LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
    private TreeSet<Integer> treeSet = new TreeSet<>();

    private Hashtable<Integer,Integer> hashtable = new Hashtable<>();
    private LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
    private HashMap<Integer,Integer> hashMap = new HashMap<>();
    private TreeMap<Integer,Integer> treeMap = new TreeMap<>();

    private ConcurrentLinkedDeque<Integer> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
    private ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    private ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();

    private ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    private ConcurrentSkipListMap<Integer,Integer> concurrentSkipListMap = new ConcurrentSkipListMap<>();
    private IdentityHashMap<Integer,Integer> identityHashMap = new IdentityHashMap<>();

    private Object[] collectionArray = new Object[]{
            integerList, // 0  THROWS CONCURRENT MODIFICATION EXCEPTION
            linkedList, // 1  THROWS CONCURRENT MODIFICATION EXCEPTION
            stack, // 2  THROWS CONCURRENT MODIFICATION EXCEPTION
            priorityQueue, // 3  THROWS CONCURRENT MODIFICATION EXCEPTION
            arrayDeque, // 4  THROWS CONCURRENT MODIFICATION EXCEPTION
            hashSet, // 5  THROWS CONCURRENT MODIFICATION EXCEPTION
            linkedHashSet, // 6  THROWS CONCURRENT MODIFICATION EXCEPTION
            treeSet, // 7  THROWS CONCURRENT MODIFICATION EXCEPTION
            hashtable, // 8  THROWS CONCURRENT MODIFICATION EXCEPTION
            linkedHashMap, // 9  THROWS CONCURRENT MODIFICATION EXCEPTION
            hashMap, // 10  THROWS CONCURRENT MODIFICATION EXCEPTION
            treeMap, // 11  THROWS CONCURRENT MODIFICATION EXCEPTION
            concurrentLinkedDeque, // 12
            concurrentLinkedQueue, // 13
            concurrentSkipListSet, // 14
            concurrentHashMap, // 15
            concurrentSkipListMap, // 16
            identityHashMap // 17 THROWS CONCURRENT MODIFICATION EXCEPTION
    };

    public Object getCollection(int index){
        return collectionArray[index];
    }

}

class SingleCollection {
    Collections c = new Collections();
    ConcurrentHashMap<Integer,Integer> concurrentHashMap = (ConcurrentHashMap<Integer, Integer>) c.getCollection(15);
}


public class CollectionAndThreading{
    public static void main(String[] args) throws InterruptedException {
        SingleCollection singleCollection = new SingleCollection();
        Thread t1 = new Thread(()->{
            for(int i = 0; i < 10000; i++) {
                singleCollection.concurrentHashMap.put(i, i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i = 0; i < 10000; i++) {
                singleCollection.concurrentHashMap.put(i, i*-1);
            }
        });

        Thread t3 = new Thread(()->{
            for(var e : singleCollection.concurrentHashMap.entrySet()){
                System.out.println(e.getKey() + "&" + e.getValue());
            }
            System.out.println("total length is : " + singleCollection.concurrentHashMap.size());
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        // SPLIT ITERATOR IS FAIL-SAFE SO IT WILL NOT THROW CONCURRENT MODIFICATION EXCEPTION
        // VECTOR CLASS IS SYNCHRONOUS BUT STILL THROWS CONCURRENT MODIFICATION EXCEPTION
    }
}