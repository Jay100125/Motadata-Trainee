package practical;

import java.util.Arrays;

public class Prac11 {
      static <T> void swap(T[] arr, int i, int j) {
        if(i < 0 || i >= arr.length || j < 0 || j >= arr.length) {
            throw new IndexOutOfBoundsException("Incorrect index");
        }

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        System.out.println("Original Array: " + Arrays.toString(arr));

        Prac11 p = new Prac11();

        swap(arr, 0, 1);
        System.out.println("Modified Array: " + Arrays.toString(arr));


        String[] str = {"one", "two", "three", "four", "five"};
        System.out.println("Original Array: " + Arrays.toString(str));

        swap(str, 0, 2);
        System.out.println("Modified Array: " + Arrays.toString(str));

    }
}
