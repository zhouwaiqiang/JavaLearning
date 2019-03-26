package com.string;

/**
 * Created by 强 on 2018/8/21.
 */
public class LSD {
    public static void sort(String[] a, int W) {
        //通过前W个字符串将a[]排序
        int N = a.length;
        String[] aux = new String[N];//辅助数组
        int R = 256;
        for (int d = W - 1; d >= 0; d--) {
            //根据第d个字符用键索引记数法排序
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {
                //建立频率表
                count[a[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++) {
                //频率转换为索引
                count[r+1] += count[r];
            }
            for (int i = 0; i < N; i++) {
                //元素分类
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            //回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
