package com.leetcode;

/**
 * Created by 强 on 2018/9/5.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class Leetcode42 {
    public int trap(int[] height) {
        int result = 0;
        int length = height.length;
        int index = 0;
        while (index < length - 1) {
            System.out.println("index is:" + index);
            if (height[index] == 0) {
                index++;
                continue;
            }
            int start = index, end = index;
            for (int j = index + 1; j < length; j++) {
                if (height[j] >= height[index]) {
                    end = j;
                    break;
                }
                if (end == index) {
                    end = j;
                } else if (height[j] >= height[end]) {
                    end = j;
                }
            }
            int comparison = height[start] <= height[end]? height[start] : height[end];
            for (int k = start + 1; k < end; k++) {
                if (height[k] <= comparison) {
                    result += (comparison - height[k]);
                }
            }
            index = end;
        }
        return result;
    }
}
