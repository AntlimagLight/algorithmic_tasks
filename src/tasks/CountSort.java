package tasks;

import java.util.Arrays;

public class CountSort {

    public static int[] sort(int[] input) {
        return sort(input, searchMax(input));
    }

    public static int[] sort(int[] input, int max) {
        int[] counter = countElements(input, max);
        int[] sorted = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            int current = input[i];
            sorted[counter[current] - 1] = current;
            counter[current] -= 1;
        }
        return sorted;
    }

    private static int[] countElements(int[] input, int max) {
        int[] buckets = new int[max + 1];
        Arrays.fill(buckets, 0);
        for (int n: input) {
            buckets[n]++;
        }
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] += buckets[i - 1];
        }
        return buckets;
    }

    private static int searchMax(int[] input){
        int max = Integer.MIN_VALUE;
        for (int n: input) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }


}
