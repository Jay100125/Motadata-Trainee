package basic;
// The formula for the return value is: -(insertion point) - 1. in binary search if array is not sorted
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.IntStream;

public class ArrayPrac {
    public static void main(String[] args) {
        int[] arr = {10,80,50,40,30,20,1};
        int[] arr1 = new int[0];
        float[] arr2f = new float[0];
        char[] arr3c = new char[0];
        boolean[] arr4b = new boolean[0];
        String[] arr5s = new String[0];
        Object[] arr6o = new Object[0];
        arr5s[0] = "Hello";
        arr5s[1] = "World";
        System.out.println(arr5s[0]);

        System.out.println(arr1.length);
//        System.out.println(Arrays.asList(arr));
        System.out.println("index : " + Arrays.binarySearch(arr, 5));
//        Arrays.sort(arr);
//        System.out.println(arr[1]);
        int[] arr2 = {1,2,2,3,4,5,6};
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.equals(arr, arr2));
        Arrays.sort(arr,1,4);
        System.out.println(Arrays.toString(arr));
        //Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        IntStream st = Arrays.stream(arr);

        st.forEach(s -> System.out.print(s + " "));

        System.out.println();
        final int[] arr3 = { 1, 2, 3, 4, 5 };

        arr3[4] = 1;

        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }

        arr2 = arr;
        System.out.println(Arrays.equals(arr, arr2));
        if(arr2 == arr)
            System.out.println("equal");
        arr[0] = 100;
        System.out.println(arr2[3]);
        System.out.println(Arrays.equals(arr, arr2));
    }
}
