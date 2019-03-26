package com.leetcode;

import java.util.Arrays;

/**
 * Created by 强 on 2018/9/21.
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        int index = 0, count = 0;
        while (index < nums.length) {
            //if (index > 0 && nums[index] < nums[index-1]) break;//跳出结束
            if (index > 1 && nums[index] == nums[index-1] && nums[index-1] == nums[index-2]) {
                int temp = nums[index];
                for (int i = index; i < nums.length; i++) {
                    if (nums[i] == temp) {
                        nums[i] = Integer.MAX_VALUE;
                        index = i+1;
                    }
                    else {
                        index = i;
                        break;
                    }
                }
                continue;
            } else count++;
            index++;
        }
        System.out.println("count is "+ count);
        Arrays.sort(nums);
        return count;
    }
}
