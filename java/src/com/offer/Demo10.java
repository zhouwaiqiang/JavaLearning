package com.offer;

/**
 * Created by 强 on 2018/12/21.
 * 斐波拉契数列
 */
public class Demo10 {
    public static void main(String[] args) {
        int result = fibonacci1(10);
        System.out.println("result is:" + result);
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    private static int fibonacci1(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        int first = 1;
        int second = 1;
        int result = 0;
        for (int i = 3; i  <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

}
