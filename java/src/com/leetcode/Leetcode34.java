package com.leetcode;

/**
 * Created by 强 on 2018/8/31.
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].
 */
public class Leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] > target) high = mid - 1;
            else if (nums[mid] < target) low = mid + 1;
            else {
                int i = low, j = high;
                while (true) {
                    while(nums[i] != target) i++;
                    while(nums[j] != target) j--;
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
