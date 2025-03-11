package collection.and.datastructure;

import java.util.*;

class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (size()  == queue.length - 1) {
            int numItems = size();
            Employee[] newQueue = new Employee[queue.length * 2];
            System.arraycopy(queue, front, newQueue, 0, queue.length - front);
            System.arraycopy(queue, 0, newQueue, queue.length-front, rear);

            queue = newQueue;

            front = 0;
            rear = numItems;
        }
        queue[rear] = employee;
        if(rear < queue.length - 1) {
            rear++;
        }
       else
        {
            rear = 0;
        }
    }

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        Employee employee = queue[front];
        queue[front] = null;
        front++;

        if(size() == 0)
        {
            front = 0;
            rear = 0;
        }else if(front == queue.length )
        {
            front = 0;

        }

        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue[front];
    }

    public int size() {
        if(front <= rear)
        {
            return rear -front;
        }
        else
        {
            return rear - front + queue.length;
        }
    }

    public void print() {
        if(front <= rear) {
            for (int i = front; i < rear; i++) {
                System.out.println(queue[i]);
            }
        }
        else
        {
            for(int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }

            for(int i = 0; i < rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }

}
public class QueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.add(new Employee(10, "A"));
        queue.add(new Employee(20, "B"));
        queue.remove();
        queue.add(new Employee(30, "C"));
        queue.remove();

        queue.add(new Employee(40, "D"));
        queue.remove();

        queue.add(new Employee(50, "E"));

        queue.print();
        System.out.println("_______________________");

        System.out.println(queue.remove());
        System.out.println("_______________________");

        queue.print();
        System.out.println("_______________________");

        System.out.println(queue.peek());
        System.out.println("_______________________");

        System.out.println(queue.size());


        Queue<String> qq = new LinkedList<>();


    }
}
