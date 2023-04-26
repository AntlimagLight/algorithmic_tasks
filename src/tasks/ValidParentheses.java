package tasks;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Every close bracket has a corresponding open bracket of the same type.

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty() || (c == ')' && stack.pop() != '(')
                    || (c == '}' && stack.pop() != '{')
                    || (c == ']' && stack.pop() != '[')) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void testsValidParentheses() {
        System.out.println(isValid("{}"));
        System.out.println(isValid("{{()}}[]"));
        System.out.println(isValid("{{[[[]]]}}()"));
        System.out.println(isValid("([[(])])"));
        System.out.println(isValid("{)"));
        System.out.println(isValid("[[(]))"));
        System.out.println(isValid("{[(}])"));
        System.out.println(isValid("["));
        System.out.println(isValid(""));
    }

}
