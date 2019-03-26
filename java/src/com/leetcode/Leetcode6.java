package com.leetcode;

/**
 * Created by 强 on 2018/10/27.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 */
public class Leetcode6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String result = "";
        String[] rowStr = new String[numRows];//存储二维数组的每一行的字符串
        int row = 0, col = 0;//row作为行的索引, col作为列的索引
        boolean direct = true;//direct向下为true,向上为false
        //将字符串装填到zigZag二维数组中
        for (int i=0; i<s.length(); i++) {
            if (rowStr[row] == null) rowStr[row] = String.valueOf(s.charAt(i));
            else rowStr[row] += String.valueOf(s.charAt(i));
            //zigZag[row][col] = s.charAt(i);
            if (row == 0) {
                direct = true;
                row++;
            } else if (row == numRows-1) {
                direct = false;
                col++;
                row--;
            } else if (direct) {
                row++;
            } else {
                row--;
                col++;
            }
        }
        for (int i=0; i<rowStr.length; i++) {
            if (rowStr[i] != null) result += rowStr[i];
        }
        System.out.println("result is:" + result);
        return result;
    }
}
