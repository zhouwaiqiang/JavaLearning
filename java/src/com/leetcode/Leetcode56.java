package com.leetcode;

import java.util.List;

/**
 * Created by 强 on 2018/9/7.
 * Given a collection of intervals, merge all overlapping intervals.
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class Leetcode56 {

    public static void main(String[] args) {
        Interval first = new Interval(5, 8);
        Interval second = new Interval(1, 5);
        boolean result = isOverlapping(first, second);
        System.out.println("result is:" + result);
    }

    private static boolean isOverlapping(Interval first, Interval second) {
        if (first.end < second.start || second.end < first.start) {
            return false;
        }
        return true;
    }

    public List<Interval> merge(List<Interval> intervals) {
        int index = 0;
        selectSort(intervals, 0);
        //一边排序一边合并
        while (index < intervals.size() - 1) {
            int count = index + 1;
            selectSort(intervals, count);
            int fstart = intervals.get(index).start;//获得第一个起始数据
            int fend = intervals.get(index).end;//获得第二个起始数据
            int nstart = intervals.get(index + 1).start;
            int nend = intervals.get(index + 1).end;
            if (nstart <= fend && nend >= fstart) {
                intervals.remove(index + 1);
                intervals.set(index, new Interval(getMin(fstart, nstart), getMax(fend,nend)));
            } else {
                index++;
            }
        }
        return intervals;
    }

    private List<Interval> mergeBackup(List<Interval> intervals) {
        int index = 0;
        selectSort(intervals, 0);
        //一边排序一边合并
        while (index < intervals.size() - 1) {
            int count = index + 1;
            selectSort(intervals, count);
            int fstart = intervals.get(index).start;//获得第一个起始数据
            int fend = intervals.get(index).end;//获得第二个起始数据
            int nstart = intervals.get(index + 1).start;
            int nend = intervals.get(index + 1).end;
            if (nstart <= fend && nend >= fstart) {
                intervals.remove(index + 1);
                intervals.set(index, new Interval(getMin(fstart, nstart), getMax(fend,nend)));
            } else {
                index++;
            }
        }
        return intervals;
    }

    //进行选择排序将对应位置排序到最小
    private static void selectSort(List<Interval> intervals, int target) {
        int min = target;//intervals.get(target).start;
        for (int i = target; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(min).start) {
                min = i;
            }
        }
        if (min != target) {
            Interval temp = intervals.get(target);
            intervals.set(target, intervals.get(min));
            intervals.set(min, temp);
        }
    }

    private static int getMin(int first, int second) {
        return first <= second? first : second;
    }

    private static int getMax(int first, int second) {
        return first >= second ? first : second;
    }
}


class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }