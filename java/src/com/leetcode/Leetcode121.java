package com.leetcode;

/**
 * Created by 强 on 2018/10/23.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * 解法：贪心算法设置一个minVal假设是当前数组的最小值，然后遍历数组用数组值减去当前的minVal的差值和目前的maxDis进行比较，如果大舅更新maxDis
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minVal = prices[0], maxDis = 0;
        for (int i = 1; i < prices.length; i++) {
            if (maxDis < prices[i] - minVal) {
                maxDis = prices[i] - minVal;
            }
            if (minVal > prices[i]) {
                minVal = prices[i];
            }
        }
        return maxDis;//贪心算法
    }
}
