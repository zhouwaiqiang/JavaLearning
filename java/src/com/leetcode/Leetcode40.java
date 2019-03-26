package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 强 on 2018/9/4.
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class Leetcode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        combination(result, temp, candidates, target);
        return result;
    }

    private static void combination(List<List<Integer>> result,
                                    List<Integer> temp,
                                    int[] candidates, int target) {
        if (target == 0) {
            if (!result.contains(new ArrayList<>(temp))) {
                result.add(new ArrayList<>(temp));
            }
            return;
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    continue;
                }
                temp.add(candidates[i]);
                combination(result, temp, Arrays.copyOfRange(candidates, i + 1, candidates.length), target - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
