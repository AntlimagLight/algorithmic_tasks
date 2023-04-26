package tasks;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder();
        prefix.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            int p = prefix.length();
            int s = strs[i].length();
            if (p > s) prefix.delete(s, prefix.length());
            if (p == 0 || s == 0) break;
            for (int j = Math.min(s, p) - 1; j >= 0; j--) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    prefix.delete(j, prefix.length());
                }
            }
        }
        return prefix.toString();
    }

    public static void startTestsPrefix() {
        String[] test1 = {"flower", "flow", "flight"};
        String[] test2 = {"sranght", "stRan", "stjko", "sthjop"};
        String[] test3 = {"dog", "racecar", "car"};
        String[] test4 = {};
        String[] test5 = {"a", "aperford", "animal"};
        String[] test6 = {"ahjk", "ahjk"};
        String[] test7 = {"ab", "a"};
        String[] test8 = {"abab","aba",""};

        System.out.println("[" + longestCommonPrefix(test1) + "]");
        System.out.println("[" + longestCommonPrefix(test2) + "]");
        System.out.println("[" + longestCommonPrefix(test3) + "]");
        System.out.println("[" + longestCommonPrefix(test4) + "]");
        System.out.println("[" + longestCommonPrefix(test5) + "]");
        System.out.println("[" + longestCommonPrefix(test6) + "]");
        System.out.println("[" + longestCommonPrefix(test7) + "]");
        System.out.println("[" + longestCommonPrefix(test8) + "]");

    }
}


