package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 强 on 2018/8/27.
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 核心思想是利用temp声明的一个ArrayList进行存储，在最后递归返回时组合成为字符串加入到result中
 *
 */
public class Leetcode17 {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> result = new ArrayList<String>();//声明结果变量
        ArrayList<Character> temp = new ArrayList<Character>();
        if (digits.isEmpty()) {
            return result;
        }
        combination(map, digits, temp, result);
        return result;
    }

    private static void combination(Map<Integer, String> map, String digits, ArrayList<Character> temp, List<String> result) {
        if (digits.length() == 0) {
            char[] arr = new char[temp.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = temp.get(i);
            }
            result.add(String.valueOf(arr));
            return;
        } else {
            Integer cur = Integer.valueOf(digits.substring(0,1));
            String lettes = map.get(cur);
            for (int i = 0; i < lettes.length(); i++) {
                temp.add(lettes.charAt(i));
                combination(map, digits.substring(1), temp, result);
                temp.remove(temp.size() - 1);//将最后一个元素移除
            }
        }
    }
}
