package com.leetcode;

/**
 * Created by 强 on 2018/9/17.
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 */
public class Leetcode67 {
    public String addBinary(String a, String b) {
        int length = a.length() > b.length()? a.length() : b.length();
        String result = "";
        int aindex = a.length() - 1, bindex = b.length() - 1, carry = 0;
        for (int i = length - 1; i >= 0; i--) {
            int temp = 0;
            if (aindex < 0) {
                temp = Integer.parseInt(String.valueOf(b.charAt(bindex--))) + carry;
                carry = 0;
            } else if (bindex < 0) {
                temp = Integer.parseInt(String.valueOf(a.charAt(aindex--))) + carry;
                carry = 0;
            } else {
                temp = Integer.parseInt(String.valueOf(a.charAt(aindex--))) +
                        Integer.parseInt(String.valueOf(b.charAt(bindex--))) + carry;
                carry = 0;
            }
            if (temp >= 2) {
                temp = temp % 2;
                carry = 1;
            }
            result = temp + result;
        }
        if (carry == 1) {
            result = "1" + result;
        }
        return result;
    }
}
