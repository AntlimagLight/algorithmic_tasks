package tasks;

import java.util.Arrays;

public class MergeNonDecreasingArrays {

    public static int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int resultPointer = 0;
        int firstPointer = 0;
        int secondPointer = 0;
        while (firstPointer < first.length && secondPointer < second.length) {
            if (first[firstPointer] < second[secondPointer]) {
                result[resultPointer] = first[firstPointer];
                firstPointer++;
            } else {
                result[resultPointer] = second[secondPointer];
                secondPointer++;
            }
            resultPointer++;
        }
        if (firstPointer >= first.length) {
            while (secondPointer < second.length) {
                result[resultPointer] = second[secondPointer];
                secondPointer++;
                resultPointer++;
            }
        } else {
            while (firstPointer < first.length) {
                result[resultPointer] = first[firstPointer];
                firstPointer++;
                resultPointer++;
            }
        }
        return result;
    }

    public static void startTests() {
        int[] mass1 = {1, 3, 4, 6, 7, 7, 9, 9};
        int[] mass2 = {2, 2, 3, 5, 7, 10};

        int[] mass3 = {1, 1, 1, 1, 1};
        int[] mass4 = {1, 2, 3, 4, 5};

        int[] mass5 = {};
        int[] mass6 = {0, 1, 3};

        int[] mass7 = {1, 2, 9, 11};
        int[] mass8 = {0, 1, 3, 8, 12, 13, 14, 16, 17, 17, 18};

        int[] mass9 = {};
        int[] mass10 = {};

        int[] mass11 = {9, 9, 9, 9};
        int[] mass12 = {9, 9, 9, 9};

        System.out.println(Arrays.toString(merge(mass1, mass2)));
        System.out.println(Arrays.toString(merge(mass3, mass4)));
        System.out.println(Arrays.toString(merge(mass6, mass5)));
        System.out.println(Arrays.toString(merge(mass8, mass7)));
        System.out.println(Arrays.toString(merge(mass10, mass9)));
        System.out.println(Arrays.toString(merge(mass11, mass12)));
    }
}
