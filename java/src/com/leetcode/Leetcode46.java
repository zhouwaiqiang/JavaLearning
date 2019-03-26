package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 强 on 2018/9/5.
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        permutation(result, temp, nums);
        return result;
    }

    private static void permutation(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
                int[] copyNum = Arrays.copyOfRange(nums, 0, nums.length);
                exch(copyNum, i, 0);
                permutation(result, temp, Arrays.copyOfRange(copyNum, 1, nums.length));
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
