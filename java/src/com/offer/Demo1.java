package com.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 强 on 2018/11/20.
 * 在一个长度为n的数组里的所有数字都在0-n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入的长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3
 */
public class Demo1 {
    public static void main(String[] args) {

    }
    /*
    解法1：对数组进行排序,然后遍历数组即可,时间复杂度O(nlogn),不同排序方法不一样，空间复杂度O(1)
     */
    public static int solution1(int[] nums) {
        //或者采用其他的排序，选择、插入、希尔、快排、堆排、冒泡、归并等
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return nums[i];
        }
        return -1;
    }

    /**
     * 解法2：采用一个哈希表，将每个值存入哈希表中，然后遍历判断哈希表中是否已有这个值，时间复杂度O(n),空间复杂度O(n)
     */
    public static int solution2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }

    /**
     * 解法3：重排数组。从头到尾扫描数组中的每个数字，当扫描下标为i的数字时，首先比较这个数字(用m表示)是不是等于i。
     * 如果是，则借着扫描下一个数字；如果不是，则再拿它和第m个数字进行比较。如果它和第m个数字相等，就找到了一个重复的数字
     * （该数字在下标为i和m的位置都出现了);如果它和第m个数字不相等，就把第i个数字和第m个数字交换，把m放到属于它的位置。接下来再
     * 重复这个比较、交换的过程，直到我们发现一个重复的数字。
     */
    public static int solution3(int[] nums) {
        if (nums.length <= 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums.length || nums[i] < 0) return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) return nums[i];
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }
        return -1;
    }
}
