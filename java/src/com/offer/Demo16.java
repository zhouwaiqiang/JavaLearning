package com.offer;

import java.awt.*;

/**
 * Created by 强 on 2018/12/29.
 */
public class Demo16 {
    public static void main(String[] args) {
        double result = power(0, 1);
        System.out.println("result is: " + result);
    }

    private static double power(double base, double exponent) {
        if (base == 0.0) return 0.0;
        int absExponent = (int) exponent;
        if (exponent < 0) absExponent = (int) -exponent;
        double result = powerWithUnsignedException(base, absExponent);
        if (exponent < 0) result = 1.0 / result;
        return result;
    }

    private static double powerWithUnsignedException(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = powerWithUnsignedException(base, exponent >> 1);
        result *= result;
        //判定最后一位是否是1，如果是1表示是奇数位，还需要乘以1个base
        if ((exponent & 0x1) == 1) result *= base;
        return result;
    }
}
