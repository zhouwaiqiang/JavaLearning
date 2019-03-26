package com.zhou.test1;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 强 on 2019/3/20.
 */
public class Iqiyi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = getDepth(str);
        System.out.println(result);
    }

    private static int getDepth(String str) {
        if (str == null || str.length() == 0) return 0;
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        int count = 0;
        for (int i=0; i<str.length(); i++) {
            if (stack.isEmpty() || str.charAt(i) == '(') {
                stack.push('(');
                count++;
            } else if(str.charAt(i) == ')') {
                stack.pop();
                maxDepth = Math.max(maxDepth, count);
                count--;
            }
        }
        return maxDepth;
    }
}
