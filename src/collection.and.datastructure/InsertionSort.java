package collection.and.datastructure;
/*
    stable sorting algorithm
    O(n^2) time complexity
    sort - unsort partition
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 9,8,7,7,4,5,6,2};
        int count = 0;
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j - 1;
                count++;
            }

            arr[j+1] = key;
        }

        for(int i : arr)
        {
            System.out.print(i + " ");
        }

        System.out.println(count);
    }
}
