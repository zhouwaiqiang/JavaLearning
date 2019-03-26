package com.leetcode;

/**
 * Created by 强 on 2018/11/4.
 */
public class Leetcode60 {
    public String getPermutation(int n, int k) {
        int[] fac = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};//阶乘结果，其中fac[0]占位
        boolean[] flags = new boolean[n];
        StringBuilder sb = new StringBuilder();
        getPermutation(sb, flags, fac, n, k);
        return sb.toString();
    }

    private void getPermutation(StringBuilder st, boolean[] flags, int[] fac, int n, int k) {
        while(true) {
            if (n == 1) {
                for (int i = 0; i < fac.length; i++) {
                    if (flags[i] == false) {
                        st.append(i+1);
                        return;
                    }
                }
            }
            int level = (k-1)/fac[n-1];
            k = k - level * fac[n-1];
            for (int i=0; i < fac.length; i++) {
                if (flags[i] == false) {
                    if (level == 0) {
                        st.append(i+1);
                        flags[i] = true;
                        break;
                    }
                    level--;
                }
            }
            n--;
        }
    }
}
