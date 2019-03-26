package com.leetcode;

/**
 * Created by 强 on 2018/9/14.
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
public class Leetcode66 {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + 1;
            if (temp <= 9) {
                digits[i] = temp;
                break;
            }
            digits[i] = 0;
            if (i == 0) {
                flag = true;
            }
        }
        if (flag) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) result[i] = digits[i-1];
            return result;
        }
        return digits;
    }
}
