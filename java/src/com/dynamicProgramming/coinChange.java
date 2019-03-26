package com.dynamicProgramming;

/**
 * Created by 强 on 2018/10/28.
 */
public class coinChange {
    public static void main(String[] args) {
        int result = getCoinCount(7);
        System.out.println(result);
    }
    private static int getCoinCount(int n) {
        int[] result = new int[n+1];//声明一个结果数组
        int[] coin = {1,3,5};
        //填充边界
        result[0]=0;
        result[1]=1;
        result[2]=2;
        result[3]=1;
        result[4]=2;
        result[5]=1;
        for (int i=6; i<=n; i++) {
            //min{result[i-coin[0]], result[i-coin[1]], result[i-coin[2]]+1}
            result[i]=Math.min(result[i-1], Math.min(result[i-3], result[i-5]))+1;
        }
        return result[n];
    }
}
