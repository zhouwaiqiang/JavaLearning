package com.zhou.test1;
/**
 * 考虑定义在两正整数上的函数SSR(平方根之和的平方):SSR(A, B) = (sqrt(A) + sqrt(B))^2。
 * 牛牛对函数值为整数的情况很感兴趣。
 * 现在给定整数n和m,请帮助牛牛计算有序对(A, B)的数量, 满足1 ≤ A ≤ n, 1 ≤ B ≤ m而且SSR(A, B)是一个整数。
 */
/**
 * 输入包括两个整数n和m(1 ≤ n ≤ 10^5, 1 ≤ m ≤ 10^5)
 * 输出一个整数,表示满足条件的有序对对数。
 * 3 8
 * 5
 */


import java.util.Scanner;

/**
 * Created by 强 on 2019/3/20.
 */
public class Iqiyi3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] square = new long[1001];
        for (int i=1; i<=1000; i++) {
            square[i] = i*i;
        }
        int result = 0;
        for (int i=1; i<=n; i++) {
            int last = getUpperIndex(square, i, n, i, m);
            System.out.println("last is: " + last);
            if (last != -1) {
            }
        }
        System.out.println(result);
    }

    private static int getUpperIndex(long[] nums, int low, int high, int value, int m) {
        while(low<=high) {
            int mid = low + (high-low)/2;
            if (nums[mid]*value <= m) low = mid+1;
            else high = mid-1;
        }
        if (high>=0 && nums[high]*value<=m) return high;
        return -1;
    }
}
