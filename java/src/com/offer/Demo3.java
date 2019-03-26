package com.offer;

/**
 * Created by 强 on 2018/12/15.
 */
public class Demo3 {
    public static void main(String[] args) {
        int[][] test = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(test, 4, 4, 11));
    }

    private static boolean find(int[][] matrix, int rows, int colums, int target) {
        if (matrix != null && rows > 0 && colums > 0) {
            int row = 0;
            int column = colums - 1;
            while (row < rows && column >= 0) {
                if (matrix[row][column] == target) return true;
                else if (matrix[row][column] > target) column--;
                else row++;
            }
        }
        return false;
    }
}
