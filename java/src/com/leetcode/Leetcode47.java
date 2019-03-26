package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 强 on 2018/9/5.
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class Leetcode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //List<Integer> temp = new ArrayList<Integer>();
        permutation(result, nums, 0, nums.length - 1);
        return result;
    }

    private static void permutation(List<List<Integer>> result, int[] nums, int start, int end) {
        if (start == end) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            if (!result.contains(temp)) {
                result.add(temp);
            }
            return;
        } else {
            for (int k = start; k <= end; k++) {
                exch(nums, start, k);
                permutation(result, nums, start + 1, end);
                exch(nums, start, k);//数组还原下一次递归
            }
        }
    }

    private static void exch(int[] nums, int i, int j) {
        if (nums[i] == nums[j] || i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
