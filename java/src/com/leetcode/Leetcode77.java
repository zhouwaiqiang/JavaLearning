package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 强 on 2018/9/20.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Cn,k 的组合
 */
public class Leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        combination(result, temp, 1, n, k);
        return result;
    }

    private static void combination(List<List<Integer>> result,
                                    List<Integer> temp,
                                    int index, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = index; i <= n; i++) {
                temp.add(i);
                combination(result, temp, i+1, n, k-1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
