package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 强 on 2018/9/21.
 */
public class Leetcode78 {

    public List<List<Integer>> subsetsOther(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int length = res.size();
            for (int j = 0; j < length; j++) {
                List<Integer> subset = new ArrayList(res.get(j));
                subset.add(nums[i]);
                res.add(subset);
            }
        }
        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        getAllSubnets(result, temp, nums);
        return result;
    }

    private static void getAllSubnets(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (nums.length == 0) {
            result.add(new ArrayList(temp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!result.contains(new ArrayList(temp))) result.add(new ArrayList(temp));
                temp.add(nums[i]);
                getAllSubnets(result, temp, Arrays.copyOfRange(nums, i+1, nums.length));
                temp.remove(temp.size()-1);
            }
        }
    }
}
