package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 强 on 2018/10/17.
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * Input: 3
 * Output: [1,3,3,1]
 */
public class Leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            result.clear();
            for (int j = 0; j <=i; j++) {
                if (j==0 || j == i) result.add(1);
                else result.add(temp.get(j-1)+temp.get(j));
            }
            temp = new ArrayList<Integer>(result);
        }
        return result;
    }
}
