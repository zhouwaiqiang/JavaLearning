package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 强 on 2018/8/27.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Leetcode22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate("", result, n, n);
        return result;
    }

    private static void generate(String s, List<String> result, int left, int right) {
        //先生成左括号再生成右括号，然后递归回溯
        if (left > right) {
            return;
        }
        if (left > 0) {
            //可以添加左括号
            generate(s + "(", result, left - 1, right);
        }
        if (right > 0) {
            generate(s + ")", result, left, right - 1);
        }
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
    }
}
