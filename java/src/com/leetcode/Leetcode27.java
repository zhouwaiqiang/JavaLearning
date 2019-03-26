package com.leetcode;

import java.util.Arrays;

/**
 * Created by 强 on 2018/8/29.
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 */
public class Leetcode27 {
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] != val) {
                        exch(nums, j, i);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return nums.length;
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
