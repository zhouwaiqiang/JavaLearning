package com.leetcode;

/**
 * Created by 强 on 2018/9/27.
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 */
public class Leetcode91 {
    public int numDecodings(String s) {
        int length = s.length();//获取到该字符串的长度
        int first = 1,second=1,third=0;//三个变量用于迭代
        if (length==0 || s.charAt(0) == '0') {
            return 0;//字符串为空，或者第一个字符是0没有解码直接返回
        }
        for (int i=2; i<=length; i++) {
            third=0;
            if (s.charAt(i-1) != '0') {
                third = second;
            }
            int num = Integer.parseInt(s.substring(i-2, i));
            if (num>=10 && num<=26) {
                third += first;
            }
            first = second;
            second = third;
        }
        return second;

    }
}
