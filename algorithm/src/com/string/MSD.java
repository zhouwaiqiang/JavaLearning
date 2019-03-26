package com.string;

import com.zhou.sort.Insertion;

/**
 * Created by 强 on 2018/8/21.
 * 高位优先字符串排序
 */
public class MSD {
    private static final int R = 256;//字符基数
    private static final int M = 15;//小数组切分阈值
    private static final int BITS_PRE_INT = 32;
    private static final int BITS_PRE_BYTE = 8;

    private MSD() {}

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a) {
        int n = a.length;
        String[] aux = new String[n];
        sort(a, 0, n-1, 0, aux);
    }

    private static void sort(String[] a, int lo, int hi, int d, String[] aux) {
        //以第d个字符为键进行字符排序
        if (hi <= lo + M) {
            insertion(a, lo, hi, d);
            return;
        }
        int[] count = new int[R+2];//计算频率
        for (int i=lo; i<=hi; i++) {
            count[charAt(a[i], d)+2]++;
        }
        for (int r=0; r< R+1; r++) {
            //频率转换为索引
            count[r+1] += count[r];
        }
        for (int i = lo; i<=hi; i++) {
            aux[count[charAt(a[i], d)+1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i-lo];
        }
        //递归的以每个字符为键进行索引
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
        }
    }

    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i=lo; i<=hi; i++) {
            for (int j=i; j > lo && less(a[j], a[j-1], d); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
}
