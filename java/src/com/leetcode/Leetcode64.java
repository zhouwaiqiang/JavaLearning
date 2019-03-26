package com.leetcode;

/**
 * Created by 强 on 2018/11/4.
 */
public class Leetcode64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 && grid[0].length == 0) return 0;
        int[][] minPath = new int[grid.length][grid[0].length];
        minPath[0][0] = grid[0][0];
        //第一行补齐边界
        for (int i=1; i<minPath[0].length; i++) minPath[0][i] = minPath[0][i-1] + grid[0][i];
        for (int i=1; i<minPath.length; i++) minPath[i][0] = minPath[i-1][0] + grid[i][0];
        //补齐中间件
        for (int i=1; i<minPath.length; i++) {
            for (int j=1; j<minPath[0].length; j++) {
                int min = Math.min(minPath[i-1][j], minPath[i][j-1]);
                minPath[i][j] = min + grid[i][j];
            }
        }
        return minPath[minPath.length-1][minPath[0].length-1];
    }
}
