package tasks;

import java.util.HashSet;

public class SingleNum {
    public static int singleNumber(int[] nums) {

        var set = new HashSet<Integer>();
        for (int n : nums) {
            if (set.contains(n)){
                set.remove(n);
            } else {
                set.add(n);
            }
        }

        return set.stream().findFirst().get();
    }


    public static void testSingleNum() {
        System.out.println(singleNumber(new int[]{2, 2, 1, 3, 3}));
        System.out.println(singleNumber(new int[]{10, 9, 10, 5, 11, 0 , 5, 8, 11, 8, 9}));
        System.out.println(singleNumber(new int[]{77}));
        System.out.println(singleNumber(new int[]{2, 4, 4}));
    }
}
