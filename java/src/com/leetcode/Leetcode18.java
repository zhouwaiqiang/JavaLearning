package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 强 on 2018/8/27.
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class Leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();//声明返回结果变量
        if (nums == null || nums.length < 4) {
            return result;
        }
        int length = nums.length;
        Arrays.sort(nums);//将数组重新排序
        for (int i = 0; i < length; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            //第二个数字循环
            for (int j = i + 1; j < length; j++) {
                //去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int begin = j + 1, end = length - 1;//高低位查找
                while (begin < end) {
                    int sum = nums[i] + nums[j] + nums[begin] + nums[end];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                        begin++;
                        end--;
                        //去重
                        while (begin < end && nums[begin] == nums[begin - 1]) {
                            begin++;
                        }
                        while (begin < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (sum > target) {
                        end--;
                    } else {
                        begin++;
                    }
                }
            }
        }
        return result;
    }
}
