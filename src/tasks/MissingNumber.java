package tasks;

/* Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array. */

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        boolean[] array = new boolean[nums.length + 1];
        for (var num : nums) {
            array[num] = true;
        }

        for (var i = 0; i <= array.length; i++) {
            if (!array[i]) {
                return i;
            }
        }
        throw new RuntimeException("Что-то пошло не так");
    }

    public static void testsMissingNumber() {
        int[] test1 = {0, 2, 4, 1};
        int[] test2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] test3 = {0, 1};
        System.out.println("3 -> " + missingNumber(test1));
        System.out.println("8 -> " + missingNumber(test2));
        System.out.println("2 -> " + missingNumber(test3));
    }


}
