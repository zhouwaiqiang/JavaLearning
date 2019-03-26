package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 强 on 2018/9/7.
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 思路：给出一个标记矩阵标记每个数是否使用添加到List中，遍历过程采用四壁往中间走的方法
 */
public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        int m = matrix.length, n = matrix[0].length, i=0, j=0;//获得行和列
        boolean[][] marked = new boolean[m][n];
        int N = m * n, count = 0;
        while (count < N) {
            result.add(matrix[i][j]);
            marked[i][j] = true;
            if (j+1 < n && !marked[i][j + 1] && (i == 0 || marked[i-1][j])) {
                j++;
            } else if (i + 1 < m && !marked[i+1][j] && (j == n - 1 || marked[i][j+1])) {
                i++;
            } else if (j - 1 >= 0 && !marked[i][j-1] && (i == m - 1 || marked[i+1][j])) {
                j--;
            } else if (i - 1 >= 0 && !marked[i-1][j] && (j == 0 || marked[i][j-1])) {
                i--;
            }
            count++;
        }
        return result;
    }
}
