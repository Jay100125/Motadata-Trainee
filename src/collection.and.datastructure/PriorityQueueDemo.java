package collection.and.datastructure;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        System.out.println(priorityQueue);
        priorityQueue.add(10);
        priorityQueue.offer(20);
        priorityQueue.offer(30);
        priorityQueue.offer(40);
        priorityQueue.offer(50);

        System.out.println(priorityQueue);
        System.out.println("size " + priorityQueue.size());
        // peek the head, return null if queue is empty
        System.out.println("peek " + priorityQueue.peek());


        System.out.println("poll " + priorityQueue.poll());
        System.out.println(priorityQueue);

        System.out.println("contains " + priorityQueue.contains(30));

        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // custom ordering (max heap)
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>((a, b) -> b - a);
        priorityQueue2.add(10);
        priorityQueue2.add(20);
        priorityQueue2.add(30);
        priorityQueue2.add(5);

        System.out.println(priorityQueue2);

//        LinkedList
//        Set<String> ss = new HashSet<>();
//        ArrayDeque

    }
}
