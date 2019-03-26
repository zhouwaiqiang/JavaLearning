package com.leetcode;

/**
 * Created by 强 on 2018/9/5.
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 */
public class Leetcode43 {
    /*
    采用乘法 total[i + j] += a[i] * b[j];//每一位
    进位处理total[i + 1] += total[i]/10;
    total[i] = total[i] % 10;
    */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "";
        int[] total = new int[num1.length() + num2.length() - 1];//声明一个存储各位结果的数组
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                total[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int k = total.length - 1; k > 0; k--) {
            total[k - 1] += total[k] / 10;
            total[k] = total[k] % 10;
            result = total[k] + result;
        }
        result = total[0] + result;
        return result;
    }
}
