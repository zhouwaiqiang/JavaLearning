package com.leetcode;

/**
 * Created by 强 on 2018/10/25.
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

 Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 Input: [7,1,5,3,6,4]
 Output: 7
 Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 简言之就是股票买入卖出，可以多次进行，求问最后的利润最大
 解题思路就是只要你明天价格比今天高我就一直握手里不抛出去，遍历一次即可
 */
public class Leetcode122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1] > prices[i]) result += prices[i+1] - prices[i];
        }
        return result;
    }
}
