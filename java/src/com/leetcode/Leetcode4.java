package com.leetcode;

/**
 * Created by 强 on 2018/8/22.
 *
 */
public class Leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int index1 = length1 - 1;//range 0 ~ length1 - 1
        int length2 = nums2.length;
        int index2 = length2 - 1;//range as follow shows
        int length = length1 + length2;
        //归并得到最终数组
        int[] aux = new int[length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < length; k++) {
            if (i > index1) {
                aux[k] = nums2[j++];
            } else if (j > index2) {
                aux[k] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                aux[k] = nums1[i++];
            } else {
                aux[k] = nums2[j++];
            }
        }
        if (length % 2 == 0) {
            int endIndex = length / 2;
            int startIndex = endIndex - 1;
            return ((double)(aux[startIndex] + aux[endIndex]))/2;
        } else {
            return aux[length/2];
        }
    }
}
