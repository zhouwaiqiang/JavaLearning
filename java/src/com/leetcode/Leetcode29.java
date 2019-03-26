package com.leetcode;

/**
 * Created by 强 on 2018/8/30.
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 */
public class Leetcode29 {
    public int divide(int dividend, int divisor) {
        boolean flag = false;//表示符号
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = true;
        }
        long lgDividend = Math.abs((long)dividend);
        long lgDivisor = Math.abs((long)divisor);
        long result = searchDivide(lgDividend, lgDivisor);
        if (result > Integer.MAX_VALUE) {
            if (!flag) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            int ans;
            if (!flag) {
                ans = (int)result;

            } else {
                ans = (int)-result;
            }
            return ans;
        }
    }

    private long searchDivide(long lgDividend, long lgDivisor) {
        if (lgDividend < lgDivisor) {
            return 0;
        }
        long sum = lgDivisor, result = 1;
        while ((sum + sum) <= lgDividend) {
            sum += sum;
            result += result;
        }
        return result + searchDivide(lgDividend -  sum, lgDivisor);
    }
}
