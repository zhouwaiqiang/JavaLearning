package com.leetcode;

/**
 * Created by 强 on 2018/9/6.
 */
public class Leetcode50 {
    public double myPow(double x, int n) {
        boolean flag = false;
        if (n < 0) {
            n = -n;
            flag = true;
        }
        double tmp = x;
        double result = 1;
        for (int i = 0; i < 32; i++) {
            //判断奇偶性，如果是奇数就进行结果相乘，因为不能在进行二分。
            if ((n & 1) == 1) result *= tmp;
            n = n >> 1;
            tmp = tmp * tmp;
        }
        return flag ? 1/result : result;
    }

    //自己写的方法，时间复杂度太高导致超时
    private static double limitExceed(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double result = 1;
        if (n < 0) {
            result = calPow(1/x, -n);
        } else {
            result = calPow(x, n);
        }
        return result;
    }

    private static double calPow(double x, int n) {
        if (n == 1) return x;
        double result = x;
        int count = 1;
        while ((count + count) < n) {
            count += count;
            result *= result;
        }
        return result * calPow(x, n - count);
    }
}
