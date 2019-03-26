package com.leetcode;

/**
 * Created by 强 on 2018/9/10.
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 */
public class Leetcode58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();//去除两端空白字符串
        int count = 0;//计数
        for (int i = s.length() - 1; i >= 0; i--) {
            //if (String.valueOf(s.charAt(i)).equals(" ")) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }
}
