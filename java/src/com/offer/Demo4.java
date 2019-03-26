package com.offer;

/**
 * Created by 强 on 2018/12/16.
 * 题目：替换空格
 * 要求：写一个函数，实现将字符串中的每个空格替换为"%20"。比如，输入"we are happy."，则输出"we%20are%20happy."。
 * 解释：在网络编程中，URL中有一些字符服务器端可能无法识别解析，比如空格、#等，因此一般要进行替换操作
 */
public class Demo4 {
    public static void main(String[] args) {
        String result = replaceBlank("We are happy.");
        System.out.println("result is:" + result);
    }
    /*
    时间复杂度为O(n^2)思路(拿不到offer)：
        从前往后遍历，每遇到一个空格的时候就将其替换，但是每次替换的时候需要将之后的字符都往后挪到2个字符，因此会造成n个空格，每次都挪动n个字符。
        导致n^2时间复杂度。
    时间复杂度O(n)思路：
        先从前往后遍历得到所有的空格数，然后从后往前遍历，每遇到一个空格将其重写到新的字符串中，由此会形成O(n)时间复杂度。
    * */
    private static String replaceBlank(String str) {
        if (str.length() == 0) return null;
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') spaceNum++;
        }
        int newLength = str.length() + spaceNum * 2;
        System.out.println("new length is:" + newLength);
        char[] arr = new char[newLength];
        int pos = newLength - 1;//新数组的下标
        for (int i = str.length()-1; i >= 0; i--) {
            if (str.charAt(i) != ' ') arr[pos--] = str.charAt(i);
            else {
                arr[pos--] = '0';
                arr[pos--] = '2';
                arr[pos--] = '%';
            }
        }
        return new String(arr);
    }
}
