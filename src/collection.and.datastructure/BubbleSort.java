package collection.and.datastructure;
/* in-place algorithm
    O(n^2) 
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };

        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length - i - 1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i : arr)
        {
            System.out.print(i + " ");
        }
    }
}

//package collection.and.datastructure;
//
//import java.util.Random;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BubbleSort {
//    public static void main(String[] args) {
//        int size = 100000; // Large array size
//        Integer[] arr = new Integer[size];
//
//        // Fill array with random numbers
//        Random random = new Random();
//        for (int i = 0; i < size; i++) {
//            arr[i] = random.nextInt(1000000);
//        }
//
//        // List to store copies of arrays (increases memory usage)
//        List<Integer[]> intermediateStates = new ArrayList<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//            // Store a copy of array in each iteration (forces more memory consumption)
//            intermediateStates.add(arr.clone());
//
//            // Artificial delay to make monitoring easier in VisualVM
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Print first 100 elements to avoid excessive console output
//        for (int i = 0; i < 100; i++) {
//            System.out.print(arr[i] + " ");
//        }
//
//        System.out.println("\nSorting complete. Stored intermediate states: " + intermediateStates.size());
//    }
//}
