package com.leetcode;

/**
 * Created by 强 on 2018/9/19.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;//获得行和列
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] <= target && matrix[i][col-1] >= target) {
                //二分查找
                int low = 0, high = col-1;
                while (low <= high) {
                    int mid = (low + high)/2;
                    if (matrix[i][mid] == target) return true;
                    else if (matrix[i][mid] < target) low = mid + 1;
                    else high = mid - 1;
                }
                return false;
            }
        }
        return false;
    }
}
