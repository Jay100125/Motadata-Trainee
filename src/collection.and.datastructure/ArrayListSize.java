package collection.and.datastructure;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSize {
    static class MyArrayList<E> extends ArrayList<E> {
        public int getCapacity() {
            // This is an approximation based on ArrayList's growth pattern
            return super.size() == 0 ? 10 : (int) (super.size() * 1.5);
        }
    }

//    static final float LOAD_FACTOR = 0.75F;

    static void size_grow(MyArrayList<Integer> e) {
        int curr_capacity;
        if (e.size() <= 10) {
            curr_capacity = 10;
        } else {
            curr_capacity = e.size();
            int new_capacity = curr_capacity + (curr_capacity / 2); // ~50% growth
            curr_capacity = new_capacity;
        }
        System.out.println("Simulated new capacity would be: " + curr_capacity);
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        System.out.println("Initial size: " + list.size());
        System.out.println("Approximate initial capacity: " + list.getCapacity());

        for (int i = 1; i <= 15; i++) {
            list.add(i);
            System.out.println("\nAdded " + i + " elements");
            System.out.println("Size: " + list.size());
            System.out.println("Approximate capacity: " + list.getCapacity());
            size_grow(list);
        }

        Collections.synchronizedList(list);
    }
}