package com.zhou.test1;

/**
 * Created by 强 on 2019/3/25.
 */
import java.util.*;
public class Solution {
    private static ArrayList<Integer> min;
    private static ArrayList<Integer> max;
    {
        min = new ArrayList<>();
        max = new ArrayList<>();
    }

    private static void swim_max(ArrayList<Integer> max, int k) {
        while (k>0 && max.get((k-1)/2)<max.get(k)) {
            exch(max, (k-1)/2, k);
            k = (k-1)/2;
        }
    }

    private static void swim_min(ArrayList<Integer> min, int k) {
        while (k>0 && min.get((k-1)/2)>min.get(k)) {
            exch(min, (k-1)/2, k);
            k = (k-1)/2;
        }
    }

    //大根堆下沉
    private static void sink_max(ArrayList<Integer> max, int k, int N) {
        while (2*k+1 < N) {
            int j = 2*k + 1;
            if (max.get(j) < max.get(j+1)) j++;
            if (max.get(k) >= max.get(j)) break;
            exch(max, k, j);
            k = j;
        }
    }

    //小根堆下沉
    private static void sink_min(ArrayList<Integer> min, int k, int N) {
        while (2*k+1 < N) {
            int j = 2*k + 1;
            if (min.get(j) > min.get(j+1)) j++;
            if (min.get(k) <= min.get(j)) break;
            exch(min, k, j);
            k = j;
        }
    }

    private static void exch(ArrayList<Integer> nums, int i, int j) {
        Integer temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }


    public void Insert(Integer num) {
        //总是把数据插入大根堆中
        max.add(num);
        swim_max(max, max.size()-1);
        //校验大根堆和小根堆的长度
        if (max.size()-min.size()==2) {
            //将大根堆根数据移动到小根堆中
            min.add(max.get(0));
            swim_min(min, min.size()-1);
            //调整大根堆
            exch(max, 0, max.size()-1);
            max.remove(max.size()-1);
            sink_max(max, 0, max.size()-1);
        }
    }

    public Double GetMedian() {
        if (max.size()==min.size()) return ((max.get(0)+min.get(0))/2.0);
        else return (double)(max.get(0));
    }


}
