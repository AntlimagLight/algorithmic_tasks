package tasks;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {
    // Есть упорядоченный массив целых чисел arr, нужно определить, есть ли в нём число X.

    public static boolean searchElement(int[] arr, int element){
        Arrays.sort(arr);
        int leftIdx = 0;
        int rightIdx = arr.length;
        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            int midElement = arr[midIdx];
            if (midElement == element) {
                return true;
            } else if (midElement < element) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx;
            }
        }
        return false;
    }

    public static void test(boolean expected, int[] array, int x) {
        if (searchElement(array, x) == expected) {
            System.out.println("Test completed");
        } else {
            System.out.println("Test failed");
        }
    }

    public static void startTestsBinarySearch() {
        int[] test1 = {-6, 90, 23, -10, 12, 54};
        int[] test2 = {1, 1};
        int[] test3 = {0};
        int[] test4 = {0, -1, 11, 11, -12, 12, 43};
        int[] test5 = {9, 9, 9, 9};
        test(true, test1,23);
        test(true, test1, -10);
        test(true, test2,1);
        test(false, test1, 0);
        test(true, test3, 0);
        test(false, test4, 1);
        test(true, test4, 11);
        test(true, test5, 9);
    }

}
