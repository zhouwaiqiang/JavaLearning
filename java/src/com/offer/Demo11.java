package com.offer;

/**
 * Created by 强 on 2018/12/24.
 * 把一个最小数字最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
 * 例如，输入数组{3,4,5,1,2}为{1.2,3,4,5}的一个旋转，该数组的最小值为1
 * 对应leetcode153,154题
 * 注意剑指offer中没有考虑数组只有一个元素的情况所以根据剑指offer的方法做会报错
 */
public class Demo11 {
    public static void main(String[] args) {
        int[] nums = {2,3,5,5,10,-10,-4,-2};
        int result = findMinI(nums);
        int max = findMax(nums);
        System.out.println("min result is: " + result);
        System.out.println("max result is: " + max);
    }

    //当数组没有重复的时候
    private static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        if (nums.length == 1 || nums[low] <= nums[high]) return nums[low];
        while (low <= high) {
            if (high - low == 1) return nums[high];
            int mid = low + (high - low) / 2;
            if (nums[low] <= nums[mid]) low = mid;
            else high = mid;
        }
        return nums[low];
    }
    //有重复数据的情况
    //根据mid和high进行比较，如果采用low会有情况无法考虑，比如nums[low] < nums[mid]时
    //此时无法判定最小数据是在mid左侧还是右侧，如果查找最大就需要使用mid和low
    private static int findMinI(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[high]) high = mid;
            else if (nums[mid] > nums[high]) low = mid + 1;
            else high--;
        }
        return nums[low];
    }

    private static int findMax(int[] nums) {
        if (nums== null || nums.length == 0) return Integer.MAX_VALUE;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            System.out.println("mid is " + mid + " " + nums[mid]);
            if (nums[low] < nums[mid]) low = mid;
            else if (nums[low] > nums[mid]) high = mid - 1;
            else high--;
        }
        return nums[high];
    }
}
