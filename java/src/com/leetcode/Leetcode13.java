package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 强 on 2018/8/26.
 */
public class Leetcode13 {
    public int romanToInt(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();//用于存储罗马数字键值对
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < length - 1; i++) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                result += map.get(s.charAt(i));
            } else {
                result -= map.get(s.charAt(i));
            }
        }
        //最后一个数字
        result += map.get(s.charAt(length -1 ));
        return result;
    }
}
