package tasks;

import java.util.*;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // Если символ уже есть в множестве, сдвигаем левый указатель
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // Добавляем текущий символ в множество
            set.add(s.charAt(right));
            // Обновляем максимальную длину
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void testResult() {
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("большаяборода"));
        System.out.println(lengthOfLongestSubstring("пустыепоезда"));
        System.out.println(lengthOfLongestSubstring("раздварааз"));
    }
}
