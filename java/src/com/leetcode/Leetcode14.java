package com.leetcode;

/**
 * Created by 强 on 2018/8/26.
 */
public class Leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) {
            return result;
        }
        int index = 0;//前缀匹配索引
        boolean ismatch = true;//用于判断是否进行下一次前缀索引匹配
        while (ismatch) {
            if (index > strs[0].length() - 1) {
                break;
            }
            char prefix = strs[0].charAt(index);
            for (int i = 0; i < strs.length; i++) {
                //检验其他字符串中的前缀是否和第一个中相同
                if ((index > strs[i].length() - 1) || strs[i].charAt(index) != prefix) {
                    ismatch = false;
                    break;//结束循环
                }
            }
            if (ismatch) {
                index++;
            }
        }
        result = strs[0].substring(0, index);
        return result;
    }
}
