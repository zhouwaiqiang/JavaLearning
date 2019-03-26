package com.leetcode;

/**
 * Created by 强 on 2018/9/19.
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 */
public class Leetcode75 {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i <= high && nums[i] == 2) {
                while (i < high && nums[high] == 2) high--;
                exch(nums, i, high);
                if (nums[i] == 0) {
                    while(low < i && nums[low] == 0) low++;
                    exch(nums, i, low);
                }
            } else if (i <= high && nums[i] == 0) {
                while (low < i && nums[low] == 0) low++;
                exch(nums, i, low);
            }
        }
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
