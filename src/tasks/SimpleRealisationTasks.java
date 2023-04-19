package tasks;

public class SimpleRealisationTasks {

    public static int getMidNumber(int[] nums){
        if (nums[0] > nums[1]) {
            return Math.min(nums[2], nums[0]);
        } else {
            return Math.min(nums[2], nums[1]);
        }
    }

    public static String reverseWords(String str){
        StringBuilder result = new StringBuilder();
        String[] words = str.split(" ");
        for (int i = words.length; i > 0;i--){
            result.append(words[i - 1]).append(" ");
        }
        return result.toString();
    }

}
