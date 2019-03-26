package com.leetcode;

/**
 * Created by 强 on 2018/8/22.
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
public class Leetcode7 {
    public int reverse(int x) {
        double result = 0;
        while (x != 0) {
            int n = x % 10;
            result = result*10 + n;
            x = x/10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }
}
