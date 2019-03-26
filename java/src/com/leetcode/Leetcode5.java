package com.leetcode;

/**
 * Created by 强 on 2018/10/26.
 * mancher算法
 */
public class Leetcode5 {

    public static void main(String[] args) {
         String test = "babad";
         String result = longestPalindrome(test);
         System.out.println("result is:" + result);
    }

    public static String longestPalindrome(String s) {
        String result = "";
        String s_new = "#";
        //构造s_new字符串
        for (int i = 0; i < s.length(); i++) {
            s_new += String.valueOf(s.charAt(i));
            s_new += "#";
        }
        System.out.println("新字符串是："+ s_new);
        int[] radius = new int[s_new.length()];
        int id = -1, mx = -1;//最大节点边界坐标
        int max_len = -1;
        for(int i = 0; i < s_new.length(); i++) {
            if (i < mx) radius[i] = Math.min(mx-i, radius[2*id-i]);
            else radius[i] = 1;

            while (i-radius[i] >=0 && i+radius[i] < s_new.length() && s_new.charAt(i-radius[i]) == s_new.charAt(i+radius[i])) {
                radius[i]++;
            }
            if (mx < i+radius[i]-1) {
                id = i;
                mx = i + radius[i] - 1;
            }
            max_len = Math.max(max_len, radius[i]-1);
        }
        System.out.println("max_len is:" + max_len);
        for (int i = 0; i < radius.length; i++) {
            System.out.println("i is:" + i + " radius is:" +radius[i]);
            if (radius[i] == max_len+1) {
                result = getResult(i-max_len, i+max_len+1, s_new, max_len);
                System.out.println("i" + result);
                if (result.isEmpty()) continue;
                return result;
            }
        }
        return "";
    }

    private static String getResult(int start, int end, String s_new, int max_len) {
        String result = "";
        if (start < 0 || end > s_new.length()) return result;
        String tempResult = s_new.substring(start, end);
        for (int i = 0; i < tempResult.length(); i++) {
            if (tempResult.charAt(i) != '#') result += String.valueOf(tempResult.charAt(i));
        }
        if (result.length() != max_len) return "";
        return result;
    }
}
