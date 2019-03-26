package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by 强 on 2018/8/27.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Input: "()"
 * Output: true
 */
public class Leetcode20 {
    public boolean isValid(String s) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");
        //使用栈实现
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals("(") ||
                    String.valueOf(s.charAt(i)).equals("[") ||
                    String.valueOf(s.charAt(i)).equals("{")) {
                //入栈
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String matchStr = String.valueOf(s.charAt(i));
                String rightStr = map.get(stack.pop());
                if (!matchStr.equals(rightStr)) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
