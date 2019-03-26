package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 强 on 2018/8/23.
 * Given a string, find the length of the longest substring without repeating characters.
 * 找出字符串中的最长匹配无重复字符串，根据set来判断，也可以用map增加count表示数量
 */
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.trim() == "") {
            return 0;
        }
        int length = s.length();
        int maxLengthString = 0;
        Set<Character> set = new HashSet<Character>();
        int i = 0, j = 0;
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                if ((j - i) > maxLengthString) {
                    maxLengthString = j - i;
                }
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLengthString;
    }
}
