package com.leetcode;

import java.util.Arrays;

/**
 * Created by 强 on 2018/8/29.
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 */
public class Leetcode26 {
    public int removeDuplicates(int[] nums) {
        Arrays.sort(nums);//先对nums进行排序
        int length = nums.length;
        int result = 0;
        //交换位置
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                for (int j = i; j < length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        exch(nums, i, j);
                        break;
                    }
                }
            }
        }
        //获取不重复数组的长度
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                System.out.println(result);
                break;
            }
            result++;
        }
        return result;
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }
}
