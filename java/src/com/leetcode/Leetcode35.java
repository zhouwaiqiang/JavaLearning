package com.leetcode;

/**
 * Created by 强 on 2018/8/31.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.
 */
public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int end = 0;//记录最后一次出现的low的位置也是要插入的位置
        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] > target) high = mid - 1;
            else if (nums[mid] < target)  low = mid + 1;
            else return mid;
            end = low;
        }
        return end;
    }
}
