package com.offer;

/**
 * Created by 强 on 2018/11/25.
 * 不修改数组找出重复的数字
 * 在一个长度为n+1的数组里的所有数字都在1-n的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7},那么对应的输出是重复的数字是2或者3
 */
public class Demo2 {
    public static void main(String[] args) {

    }

    private static String exchStr(String str, int index1, int index2) {
         StringBuilder strBuilder = new StringBuilder(str);
         strBuilder.setCharAt(index1, str.charAt(index2));
         strBuilder.setCharAt(index2, str.charAt(index1));
         return str = strBuilder.toString();
    }
    //引入辅助数组aux然后采用第一题中的方式将数字归位写入查找可以实现不修改原数组找到相同的数字
    //时间复杂度O(n),空间复杂度O(n)
    private static int getDuplication1(int[] nums, int length) {
        int[] aux = new int[length];
        for (int i = 0; i < nums.length; i++) {
            if (aux[nums[i]] == nums[i]) return nums[i];
            aux[nums[i]] = nums[i];
        }
        return -1;
    }

    private static int getDuplication2(int[] nums, int length) {
        if (nums.length == 0 || length <= 0) return -1;
        int start = 1;
        int end = length - 1;
        while (start <= end) {
            //防止溢出
            int mid = (end - start) / 2 + start;
            int count = countRange(nums, length, start, mid);
            if (end == start) {
                if (count > 1) return start;
                else break;
            }
            if (count > (mid - start + 1)) end = mid;
            else start = mid + 1;
        }
        return -1;
    }

    private static int countRange(int[] nums, int length, int start, int end) {
        if (nums.length == 0) return 0;
        int count = 0;
        for (int num : nums) {
            if (num >= start && num <= end) count++;
        }
        return count;
    }
}
