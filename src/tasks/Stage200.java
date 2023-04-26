package tasks;

import java.util.Arrays;
import java.util.List;

//Вам дан массив натуральных чисел n
//Найдите число таких пар элементов (n[i] - n[j]) % 200 == 0 i < j
//В первой строке дан размер массива
//Во второй строке через пробел записаны элементы массива

public class Stage200 {

    public static long getNumberOfGoodPairs(int n, List<Integer> numbers) {
        int counter = 0;
        for (Integer num : numbers) {
            for (int i = numbers.indexOf(num) + 1; i < n; i++) {
                if ((num - numbers.get(i)) % 200 == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void startTests() {
        Integer[] test1 = {203, 404, 204, 200, 403};
        int test1size = 5;
        Integer[] test2 = {1000000};
        int test2size = 1;
        Integer[] test3 = {2022, 2020, 2021};
        int test3size = 3;

        System.out.println(getNumberOfGoodPairs(test1size, Arrays.asList(test1)));
        System.out.println(getNumberOfGoodPairs(test2size, Arrays.asList(test2)));
        System.out.println(getNumberOfGoodPairs(test3size, Arrays.asList(test3)));
    }

}
