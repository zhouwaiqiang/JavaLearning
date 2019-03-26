package com.leetcode;

/**
 * Created by 强 on 2018/10/28.
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 */
public class Leetcode38 {
    public String countAndSay(int n) {
        String result = "1";
        for (int i=2; i<=n; i++) {
            String temp = result;
            result = "";
            int index = 0, length = temp.length();//遍历字符串temp的索引
            while (index < length) {
                char curr = temp.charAt(index);
                int count = 0;//记录当前有多少个重复的数字
                while (index < length && temp.charAt(index) == curr) {
                    count++;
                    index++;
                }
                result += String.valueOf(count) + String.valueOf(curr);
            }
        }
        return result;
    }
}
