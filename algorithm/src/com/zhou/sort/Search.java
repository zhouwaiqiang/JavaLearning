package com.zhou.sort;

/**
 * Created by 强 on 2019/3/20.
 * 二分查找
 * 查找下界和上界
 */
public class Search {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4,5,5,5,6,7,8,9};
        int re1 = binary_search(nums, 4);
        int re2 = get_lower(nums, 2);
        int re3 = get_upper(nums, 5);
        System.out.println(re1);
        System.out.println(re2);
        System.out.println(re3);
    }

    private static int binary_search(int[] nums, int key) {
        int low = 0, high = nums.length-1;
        while(low<=high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] > key) high = mid-1;
            else if (nums[mid] < key) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int get_lower(int[] nums, int key) {
        int low=0, high = nums.length-1;
        System.out.println("test");
        while(low<=high) {
            int mid = low + (high-low)/2;
            if (nums[mid] >= key) high = mid-1;
            else low = mid+1;
        }
        if (low<nums.length && nums[low]== key) return low;
        return -1;
    }

    private static int get_upper(int[] nums, int key) {
        int low = 0, high = nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if (nums[mid] <= key) low = mid+1;
            else high = mid-1;
        }
        if(high>=0 && nums[high]==key) return high;
        return -1;
    }
}
