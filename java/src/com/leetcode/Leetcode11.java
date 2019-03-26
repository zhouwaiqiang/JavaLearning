package com.leetcode;

/**
 * Created by 强 on 2018/8/24.
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 */
public class Leetcode11 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int result  = getArea(height, i, j);
                max = result > max ? result : max;
            }
        }
        return max;
    }

    private int getArea(int[] height, int i, int j) {
        int width = j - i;
        int heig = height[i] < height[j] ?height[i] : height[j];
        int area = width * heig;
        return area;
    }
}
