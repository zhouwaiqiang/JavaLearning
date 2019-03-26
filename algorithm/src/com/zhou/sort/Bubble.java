package com.zhou.sort;

import com.zhou.prepare.StdOut;

/**
 * Created by 强 on 2018/11/21.
 * 冒泡排序：每次进行两个数字的比较，较大者放到后面，从前往后依次进行直到最后一个是本轮次的最大的数，然后继续下一轮直到整个数组有序
 */
public class Bubble {
    public static void main(String[] args) {
        Integer[] a = {5, 3, 2, 10, 1, 15, 4,90};
        bubble_sort(a);
        show(a);
        System.out.println(isSorted(a));
    }

    private static void sort(Comparable[] a) {
        //外层循环控制轮次
        for (int i = 0; i < a.length; i++) {
            //内存循环控制比较
            for (int j = 0; j < a.length - i - 1; j++) {
                if (less(a[j+1], a[j])) exch(a, j, j+1);
            }
        }
    }

    /**
     * 将双层for循环进化为一个while循环加一个for循环，此时若数组处于有序状态可以大大减小排序时间
     * 比如数组本身有序，那么时间复杂度进化为O(n),逆序状态下与原始冒泡排序等同，平均复杂度和逆序等同
     * @param a
     */
    private static void bubble_sort(Comparable[] a) {
        int pos = a.length - 1;
        while (pos != 0) {
            int bound = pos;
            pos = 0;//用于标记是否有交换记录，若有，则记录"下一趟要处理的最后一个位置"
            for (int j = 0; j < bound; j++) {
                if (less(a[j+1], a[j])) {
                    exch(a, j, j+1);
                    pos = j;
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i=1; i<a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
}
