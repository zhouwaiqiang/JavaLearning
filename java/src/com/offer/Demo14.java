package com.offer;

/**
 * Created by 强 on 2018/12/28.
 * cut the rope
 */
public class Demo14 {
    public static void main(String[] args) {
        int result = greedyCutRope(7);
        System.out.println("result is: " + result);
    }

    private static int cutRope(int length) {
        int[] products = new int[length+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int k = 4; k <= length; k++) {
            int max = 0;
            for (int i = 1; i <= k/2; i++) {
                max = Math.max(max, products[i] * products[k-i]);
            }
            products[k] = max;
        }
        return products[length];
    }

    //贪心算法
    private static int greedyCutRope(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;
        int timeOf3 = length / 3;
        if (length - timeOf3 * 3 == 1) timeOf3 -=1;
        int timeOf2 = (length - timeOf3*3) / 2;
        return (int)Math.pow(3, timeOf3)*(int)Math.pow(2, timeOf2);
    }
}
