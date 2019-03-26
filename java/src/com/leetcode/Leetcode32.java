package com.leetcode;

import java.util.Stack;

/**
 * Created by 强 on 2018/10/30.
 * 求解给定的字符串中的最长的括号匹配数量，比如(()为2，()())为4,()(()为2
 * 可以采用动态规划
 */
public class Leetcode32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();//这里存储的是字符串的索引，不存储字符(
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                if(s.isEmpty()) result = Math.max(result, i+1);
                else result = Math.max(result, i-stack.peek());
            } else stack.push(i);
        }
        return result;
    }
}
