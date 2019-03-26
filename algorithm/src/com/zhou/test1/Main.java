package com.zhou.test1;
import java.util.*;
/**
 * Created by 强 on 2019/3/18.
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int k1 = sc.nextInt();
        int x2 = sc.nextInt();
        int k2 = sc.nextInt();
        String result = compareRepeatXK(x1, k1, x2, k2);
        System.out.println(result);
        */
        ArrayList<String> result = new ArrayList<>();
        result.add("abc");
        result.add("acb");
        result.add("bac");
        result.add("bca");
        result.add("cba");
        result.add("cab");
        lsd_sort(result, result.get(0).length());
        System.out.println("排序后：");
        for (int i=0; i<result.size(); i++) System.out.println(result.get(i));
    }

    private static void lsd_sort(ArrayList<String> result, int W) {
        int N = result.size();
        int R = 256;
        String[] aux = new String[N];
        for (int d = W-1; d>=0; d--) {
            int[] count = new int[R+1];
            //计算频率
            for (int i=0; i<N; i++) {
                count[result.get(i).charAt(d)+1]++;
            }
            //将频率转换为索引
            for (int r=0; r<R; r++) {
                count[r+1] += count[r];
            }
            //将元素分类
            for (int i=0; i<N; i++) {
                aux[count[result.get(i).charAt(d)]++] = result.get(i);
            }
            result.clear();
            //回写
            for (int i=0; i<N; i++) {
                result.add(aux[i]);
            }
        }
    }

    private static String compareRepeatXK(int x1, int k1, int x2, int k2) {
        int x1_length = String.valueOf(x1).length();
        int total1 = x1_length* k1;
        int x2_length = String.valueOf(x2).length();
        int total2 = x2_length* k2;
        if (total1 > total2) return "Greater";
        else if (total1 < total2) return "Less";
        else {
            int index = 0;
            String str1 = String.valueOf(x1);
            String str2 = String.valueOf(x2);
            while (index < total1) {
                if (str1.charAt(index%x1_length) > str2.charAt(index%x2_length)) return "Greater";
                else if (str1.charAt(index%x1_length) < str2.charAt(index%x2_length)) return "Less";
                else index++;
            }
            return "Equal";
        }
    }
}
