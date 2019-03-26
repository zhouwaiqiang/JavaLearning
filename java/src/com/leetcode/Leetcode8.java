package com.leetcode;

/**
 * Created by 强 on 2018/8/22.
 * Implement atoi which converts a string to an integer.

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.
 */
public class Leetcode8 {
    public int myAtoi(String str) {
        str = str.trim();//去除空格
        boolean flag = true;//判断正负号
        if (str.equals("")||((str.length() == 1) && (str.charAt(0)=='+' ||str.charAt(0)=='-'))) return 0;
        if (str.charAt(0)=='+' || str.charAt(0)=='-'||(str.charAt(0)>=48 && str.charAt(0) <= 57)) {
            double result = 0;
            String resultStr = "";
            if (str.charAt(0) == '+') {
                flag = true;
            } else if (str.charAt(0) == '-') {
                flag = false;
            } else {
                resultStr += str.charAt(0);
            }
            for (int i=1; i < str.length(); i++) {
                if (str.charAt(i)>= 48 && str.charAt(i) <= 57) {
                    resultStr += str.charAt(i);
                } else {
                    break;
                }
            }
            if (resultStr.equals("")) {
                return 0;
            }
            result = Double.parseDouble(resultStr);
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                if (!flag) {
                    return (int)-result;
                }
                return (int)result;
            }
        }
        else {
            return 0;
        }
    }
}
