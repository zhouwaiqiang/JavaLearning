package com.zhou.sort;

/**
 * Created by 强 on 2019/4/6.
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] num = new int[50];
        for (int i=0; i<num.length; i++) {
            num[i] = (int)(Math.random()*1000);
        }
        radixSort(num, 1000);
        System.out.println("the result is order: " + isSorted(num));
        for (int i=0; i<num.length; i++) {
            System.out.print(num[i]+ " ");
        }
    }

    private static void radixSort(int[] array, int d) {
        int n = 1;//代表位数对应的数:1、10、100
        int length = array.length;
        int[][] bucket = new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[] order = new int[10];//用于保存每个桶里有多少个数字,一共有10个桶
        while (n<d) {
            for (int num:array) {
                //将数组array每个数字放在相应的桶里
                int digit = (num/n)%10;
                bucket[digit][order[digit]]=num;
                order[digit]++;
            }
            int k=0;//回写到原数组时，原数组下标索引
            for (int i=0; i<10; i++) {
                //将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
                if(order[i]!=0) {
                    //这个桶里有数据，从上到下排序并将数据保存到原数组中
                    for (int j=0; j<order[i]; j++) {
                        array[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i]=0;//将桶里计数器清零，用于下一次位排序
            }
            n*=10;
        }
    }

    private static boolean isSorted(int[] a) {
        for (int i=1; i<a.length; i++) {
            if (a[i]<a[i-1]) {
                return false;
            }
        }
        return true;
    }
}
