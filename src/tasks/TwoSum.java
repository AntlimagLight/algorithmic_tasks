package tasks;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.*/

import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i];
                int b = nums[j];
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void testsTwoSum() {
        int[] test1 = {2, 7, 11, 15};
        int[] test2 = {3, 2, 4};
        int[] test3 = {3, 3};
        System.out.println(Arrays.toString(twoSum(test1, 9)));
        System.out.println(Arrays.toString(twoSum(test2, 6)));
        System.out.println(Arrays.toString(twoSum(test3, 6)));
    }


}
