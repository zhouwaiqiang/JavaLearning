package com.leetcode;

/**
 * Created by 强 on 2018/11/4.
 *  robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 */
public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        //动态规划
        int[][] result = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 0) result[0][0] = 1;
        else result[0][0] = 0;
        //将第一行的边界条件填满
        for (int i = 1; i < result[0].length; i++) {
            if (obstacleGrid[0][i] == 0) {
                result[0][i] = result[0][i-1];
            } else result[0][i] = 0;
        }
        //将第一列边界填满
        for (int i = 1; i < result.length; i++) {
            if (obstacleGrid[i][0] == 0) {
                result[i][0] = result[i-1][0];
            } else result[i][0] = 0;
        }
        //动态执行
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    result[i][j] = result[i-1][j] + result[i][j-1];
                } else result[i][j]  = 0;
            }
        }
        return result[result.length-1][result[0].length-1];
    }
}
