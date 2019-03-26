package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 强 on 2018/9/10.
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 */
public class Leetcode57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        boolean flag = false;//判断是否将新的interval加入
        for (int i = 0; i < intervals.size(); i++) {
            if (!isOverlapping(intervals.get(i), newInterval)) {
                if (isBeforeInterval(intervals.get(i), newInterval) && !flag) {
                    result.add(newInterval);
                    flag = true;
                }
                result.add(intervals.get(i));
            } else if (isOverlapping(intervals.get(i), newInterval) && !flag) {
                //第一次相交
                result.add(merge(intervals.get(i), newInterval));
                flag = true;
            } else {
                //非第一次相交
                result.set(result.size()-1, merge(intervals.get(i), result.get(result.size() - 1)));
            }
        }
        if (!flag) {
            //表明整个链表遍历未找到
            result.add(newInterval);
        }
        return result;
    }

    //判断是否在一个Interval之前
    private static boolean isBeforeInterval(Interval first, Interval target) {
        if (target.end < first.start) {
            return true;
        }
        return false;
    }

    //判断两个Interval是否相交
    private static boolean isOverlapping(Interval first, Interval second) {
        if (first.end < second.start || second.end < first.start) {
            return false;
        }
        return true;
    }

    private static Interval merge(Interval first, Interval second) {
        return new Interval(getMin(first.start, second.start), getMax(first.end, second.end));
    }

    private static int getMin(int first, int second) {
        return first <= second? first : second;
    }

    private static int getMax(int first, int second) {
        return first >= second ? first : second;
    }
}
