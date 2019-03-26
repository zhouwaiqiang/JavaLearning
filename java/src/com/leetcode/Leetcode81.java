package com.leetcode;

/**
 * Created by 强 on 2018/9/21.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

 * You are given a target value to search. If found in the array return true, otherwise return false.
 */
public class Leetcode81 {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < nums[high] || nums[mid] < nums[low]) {
                if (nums[mid] < target && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            } else if(nums[mid] > nums[low] || nums[mid] > nums[high])  {
                if (nums[mid] > target && target >= nums[low]) high = mid - 1;
                else low = mid + 1;
            } else {
                high--;
            }
        }
        return false;
    }
}
