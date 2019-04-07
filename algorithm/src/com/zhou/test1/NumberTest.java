package com.zhou.test1;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 强 on 2019/3/27.
 */
public class NumberTest {
    public static void main(String[] args) {
        /*char[] str = {'1', '0', '0'};
        boolean result = isNumeric(str);
        System.out.println(result);
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        if (map.containsKey('a')) System.out.println("aa");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }*/
        String str = "student. a am I";
    }


    private static Map<Character, Integer> map = new LinkedHashMap<>();;

    private static void printMap() {
        for (Map.Entry<Character, Integer> entry:map.entrySet()) {
            System.out.println("key is: " + entry.getKey() + " value is: " + entry.getValue());
        }
    }

    public static int FirstNotRepeatingChar(String str) {
        if (str==null || str.length()==0) return -1;
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            System.out.println("char is: " + ch);
            if (map.containsKey(ch)) {
                map.put(ch, 2);
            } else map.put(ch, 1);
        }
        int count = 0;
        for (Map.Entry<Character, Integer> entry:map.entrySet()) {
            if (entry.getValue()==1) return count;
            count++;
        }
        return -1;
    }


    public static boolean isNumeric(char[] str) {
        if(str==null || str.length==0) return false;
        int[] start = {0};//存储字符串索引下标
        boolean result = scanInteger(str, start);
        if (start[0]<str.length && str[start[0]]=='.') {
            start[0]++;
            result = scanUnsignedInteger(str, start) || result;
        }
        if (start[0]<str.length && (str[start[0]]=='e'||str[start[0]]=='E')) {
            start[0]++;
            result = result&&scanInteger(str, start);
        }
        return result&&(start[0]==str.length);
    }

    private static boolean scanInteger(char[] str, int[] start) {
        int index = start[0];
        if (index >= str.length) return false;
        if (str[index]=='+' || str[index] == '-') index++;
        start[0] = index;
        return scanUnsignedInteger(str, start);
    }

    private static boolean scanUnsignedInteger(char[] str, int[] start) {
        int index = start[0];
        while (index != str.length && str[index]>='0' && str[index]<='9') {
            index++;
        }
        boolean result = index > start[0];
        start[0] = index;
        return result;
    }
}

