package com.leetcode;

/**
 * Created by 强 on 2018/9/18.
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * Example
 * Input:
 * [
 * [1,1,1],
     [1,0,1],
     [1,1,1]
     ]
     Output:
     [
     [1,0,1],
     [0,0,0],
     [1,0,1]
     ]
 */
public class Leetcode73 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int rowLength = matrix.length, colLength = matrix[0].length, min = 0;//min表示要置换的行的最小值
        boolean[] col = new boolean[matrix[0].length];
        boolean row = false;//判断行是否换为0
        for (int i = 0; i < rowLength; i++) {
            row = false;
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    row = true;
                    //matrix[i] = new int[matrix[0].length];
                    col[j] = true;
                    //将此列和之前的所有列代表的值置为0
                    for (int k = i; k >= 0; k--) {
                        matrix[k][j] = 0;
                    }
                    continue;
                }
                if (col[j]) {
                    matrix[i][j] = 0;
                }
            }
            if (row) {
                matrix[i] = new int[colLength];
            }
        }
    }
}
