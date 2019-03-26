package com.leetcode;

import java.util.Arrays;

/**
 * Created by 强 on 2018/9/27.
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 */
public class Leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copyNums1 = Arrays.copyOf(nums1, nums1.length);
        int i = 0, j = 0, length2 = nums2.length, length1 = nums1.length - length2;
        for (int index = 0; index < nums1.length; index++) {
            if (i >= length1) nums1[index] = nums2[j++];
            else if (j >= length2) nums1[index] = copyNums1[i++];
            else if (copyNums1[i] >= nums2[j]) nums1[index] = nums2[j++];
            else nums1[index] = copyNums1[i++];
        }
    }
}
