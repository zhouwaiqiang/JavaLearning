package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 强 on 2018/10/17.
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 */
public class Leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            temp.clear();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i) temp.add(1);
                else temp.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            result.add(new ArrayList<Integer>(temp));
        }
        return result;
    }
}
