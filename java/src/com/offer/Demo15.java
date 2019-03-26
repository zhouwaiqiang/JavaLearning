package com.offer;

/**
 * Created by 强 on 2018/12/28.
 */
public class Demo15 {
    public static void main(String[] args) {
        int result = getOneNumberI(9);
        int result1 = getOneNumberII(9);
        System.out.println("result is: " + result);
        System.out.println("result II is: " + result1);
    }

    private static int getOneNumberI(int num) {
        int count = 0;
        int start = 1;
        while (start != 0) {
            if ((num & start) != 0) count++;
            start = start << 1;
        }
        return count;
    }

    private static int getOneNumberII(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = (num-1) & num;
        }
        return count;
    }
}
