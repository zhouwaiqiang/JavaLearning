package com.leetcode;

/**
 * Created by 强 on 2018/8/29.
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class Leetcode28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int result = -1;//声明结果变量
        int match = 0;//index表示needle的索引，match表示haystack索引
        while (match < haystack.length()) {
            if (haystack.charAt(match) == needle.charAt(0)) {
                int index = 0;
                while (index < needle.length()) {
                    int temp = match + index;
                    if (temp >= haystack.length() || (haystack.charAt(temp) != needle.charAt(index))) {
                        break;
                    }
                    index++;
                }
                if (index == needle.length()) {
                    result = match;
                    return result;
                }
            }
            match++;
        }
        return result;
    }
}
