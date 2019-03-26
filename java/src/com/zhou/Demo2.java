package com.zhou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 强 on 2018/9/11.
 */
public class Demo2 {
    public static void main(String[] args) {
        String result = getPermutation(3, 5);
        //System.out.println("result is:" + result);

    }

    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<Integer> temp = new ArrayList<Integer>();//设置存储变量
        String[] result = new String[1];//存储结果的数组
        result[0] = "";
        int[] count = new int[1];//存储计数器
        permutation(nums, temp, result, count, k);
        return result[0];
    }

    private static void permutation(int[] nums, List<Integer> temp, String[] result, int[] count, int k) {
        if (nums.length == 0) {
            count[0]++;
            String tempStr = "";
            for (int i = 0; i < temp.size(); i++) {
                tempStr += temp.get(i);
            }
            result[0] = tempStr;
            System.out.println("第" + count[0] + "次是：" + tempStr );
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
                permutation(copyArray(nums, i), temp, result, count, k);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static void showArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums is:" + nums[i]);
        }
    }

    private static int[] copyArray(int[] nums, int target) {
        int temp = nums[target];
        for (int i = target; i > 0; i--) nums[i] = nums[i - 1];
        nums[0] = temp;
        return Arrays.copyOfRange(nums, 1, nums.length);
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
