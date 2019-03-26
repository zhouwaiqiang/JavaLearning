package com.leetcode;

/**
 * Created by 强 on 2018/8/22.
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Input: 121
 *Output: true
 * 是否有回文， 121是，10不是，1221是
 */
public class Leetcode9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;//小于0有负号肯定不是
        }
        //change number x to String
        /*
        1. String text = String.valueOf(x);
        2. String text = "" + x;
        3. String text = (String)x;
        */
        String result = String.valueOf(x);
        for (int i = 0; i <= result.length() - 1 - i; i++) {
            if (result.charAt(i) != result.charAt(result.length() -1 -i)) {
                return false;
            }
        }
        return true;
    }
}
