package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Palindrome {

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        List<Integer> nums = new ArrayList<>();
        int pointer = x;
        while (pointer > 0) {
            nums.add(pointer % 10);
            pointer = pointer / 10;
        }
        for (int i = 0; i < nums.size() / 2; i++) {
            if (!Objects.equals(nums.get(i), nums.get(nums.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }

}
