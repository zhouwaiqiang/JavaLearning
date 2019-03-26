package com.leetcode;

/**
 * Created by 强 on 2018/8/24.
 * Integer to Roman
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 */
public class Leetcode12 {
    public String intToRoman(int num) {
        String[] aux = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int index = 0;//aux的下标索引
        String result = "";
        while (num != 0) {
            int sNum = num % 10;//取个位数
            String temp = getString(aux, sNum, index);
            result = temp + result;
            num = num / 10;
            index = index + 4;
        }
        return result;
    }

    private String getString(String[] aux, int num, int index) {
        String tempStr = "";
        if (num < 4) {
            tempStr = copy(aux[index], num);
        } else if (num > 5 && num < 9) {
            tempStr = aux[index + 2] + copy(aux[index] , num - 5);
        } else {
            switch(num) {
                case 4:
                    tempStr = aux[index + 1];
                    break;
                case 5:
                    tempStr = aux[index + 2];
                    break;
                case 9:
                    tempStr = aux[index + 3];
                    break;
                default:
                    break;
            }
        }
        return tempStr;
    }

    private String copy(String str, int n) {
        String tempStr = "";
        for (int i = 0; i < n; i++) {
            tempStr += str;
        }
        return tempStr;
    }
}
