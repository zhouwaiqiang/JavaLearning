package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 强 on 2018/9/4.
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 * 注：Arrays.copyOfRange(array[], int from, int to)表示截取数组中一部分组成一个新的数组，包含from不包含to
 */
public class Leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        combination(result, temp, candidates, target);
        return result;
    }

    private static void combination(List<List<Integer>> result,
                                    List<Integer> temp,
                                    int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    continue;
                }
                temp.add(candidates[i]);
                combination(result, temp, Arrays.copyOfRange(candidates, i, candidates.length), target - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
