package com.leetcode;

/**
 * Created by 强 on 2018/10/28.
 * 爬梯子最简单的动态规划
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Leetcode70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        //入门级别的动态规划
        int a = 1, b = 2;//1级阶梯和2级阶梯的方式数量
        int result=0;
        for (int i=3;  i<=n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}
