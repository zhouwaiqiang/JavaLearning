package com.leetcode;

import java.util.Arrays;

/**
 * Created by 强 on 2018/8/30.
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place and use only constant extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 找出全排列交换的下一个最小值
 */
public class Leetcode31 {
    public void nextPermutation(int[] nums) {
        int start = -1, end = -1;//表示要交换的两个位置
        for (int i = nums.length - 1; i >= 0; i--) {
            if (start > i - 1) {
                break;
            }
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[i] > nums[j]) && j > start) {
                    start = j;
                    end = i;
                }
            }
        }
        if (start != -1) {
            exch(nums, start, end);
            selectSort(nums, start + 1, nums.length - 1);
            return;
        } else {
            Arrays.sort(nums);
            return;
        }
    }

    private void selectSort(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            int min = i;
            for (int j = i + 1; j <= end; j++) {
                if (nums[j] < nums[i]) {
                    min = j;
                }
            }
            exch(nums, i, min);
        }
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
