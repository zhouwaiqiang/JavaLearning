package com.zhou;

/**
 * Created by 强 on 2017/12/14.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
public class Solution {
    public static void main(String[] args) {
        String test = "+1232aa";
        String result="";
        for (int i = 0; i < test.length(); i++) {
            if (test.charAt(0)=='+' || test.charAt(0)=='-'||(test.charAt(i) >= 48 && test.charAt(i) <= 57)) {
                result += test.charAt(i);
            }
        }
        System.out.println(result);
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("^[-\\+]?[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.find()) {
            if (isNum.group().equals("")) {
                System.out.println("空");
                return false;
            } else {
                System.out.println("非空");
                double test = 232;
                System.out.println(isNum.group());
                return true;
            }
        }
        return false;
    }

    public static int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }
        int result = 0;
        boolean flag = true;//标记符号, true表示为正

        System.out.println(flag);
        while (x != 0) {
            int n = x % 10;
            result = result*10 + n;
            x = x/10;
        }

        return result;
    }

    public static int[] twoSum(int nums[], int target) {
        int[] result = new int[2];
        //两层循环查找
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                System.out.println("和为：" + sum);
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    private static int getPow(int a, int n) {
        //a的n次方表示
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result*a;
        }
        return result;
    }
}
