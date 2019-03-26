package com.leetcode;

import java.util.Arrays;

/**
 * Created by 强 on 2018/9/4.
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Input: [1,2,0]
 * Output: 3
 * Input: [3,4,-1,1]
 * Output: 2
 */
public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);//先排序
        if (nums.length == 0) {
            return 1;
        }
        int  match = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            if (nums[i] == match) {
                match++;
            } else if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            } else {
                break;
            }
        }
        return match;
    }
}
