package tasks;

public class DoublePointer {

    // Дан массив целых положительных чисел arr и целое число X.
    // Определите, существует ли в массиве такой непрерывный подмассив, что сумма его элементов равна X.

    public static boolean checkArray(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            var sum = arr[i];
            int nextIdx = i + 1;
            while (sum <= x && nextIdx < arr.length) {
                sum += arr[nextIdx];
                if (sum == x) {
                    return true;
                }
                nextIdx++;
            }
        }
        return false;
    }

    public static void test(boolean expected, int[] array, int x) {
        if (checkArray(array, x) == expected) {
            System.out.println("Test completed");
        } else {
            System.out.println("Test failed");
        }
    }

    public static void startTestsDoublePointer() {
        int[] ints = {1, 2, 3, 10};
        int[] test1 = {3, 6, 9, 10, 122};
        int[] test2 = {1, 1};
        int[] test3 = {0};
        int[] test4 = {0, 5, 11, 11, 12, 12, 15};
        int[] test5 = {9, 9, 9, 9};
        test(true, ints, 5);
        test(true, test1, 28);
        test(false, test1, 29);
        test(false, test2, 1);
        test(true, test2, 2);
        test(false, test3, 1);
        test(true, test4, 5);
        test(true, test5, 36);
    }

}
