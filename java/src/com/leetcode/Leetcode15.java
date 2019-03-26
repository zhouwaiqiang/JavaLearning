package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 * Created by 强 on 2018/8/26.
 */
public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//先对数组进行排序
        List<List<Integer>> result = new ArrayList<List<Integer>>();//声明需要返回的结果变量
        int length = nums.length;//获得数组长度
        if (length == 0 || nums[length-1] < 0) {
            return result;//不存在
        }
        int j=0,k=0;//声明后面需要索引的变量
        int prej=0,prek=0;//j、k的前一个值
        for (int i=0; i<length-2; i++) {
            if (nums[i]>0) {
                break;
            }
            if (i>0 && nums[i] == nums[i-1]) {
                continue;//继续下一个循环
            }
            int temp = -nums[i];//后面需要作比较的值
            j=i+1;
            k=length-1;
            int count = 0;//计数
            while (true) {
                while(equal(nums[j]+nums[k], temp)) {
                    if (nums[j]+nums[k] < temp) {
                        j++;
                    } else {
                        k--;
                    }
                    if (j>=k) {
                        break;
                    }
                }
                if (j>=k) {
                    break;//结束循环
                }

                //遍历是否已经有该组合
                boolean flag = false;//检测标志，如果没有为false，如果有了那就是true
                if (nums[prej] == nums[j] && nums[prek] == nums[k]) {
                    flag = true;
                }
                if (!flag || count == 0) {
                    /*List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);
                    result.add(tempList);*/
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
                prej = j;
                prek = k;
                k--;//减少
                j++;//增值
                count++;
            }
        }
        return result;
    }

    private boolean equal(int v, int w) {
        if (v == w) {
            return false;
        } else {
            return true;
        }
    }
}
