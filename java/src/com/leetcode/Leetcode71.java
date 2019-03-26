package com.leetcode;

import java.util.Stack;

/**
 * Created by 强 on 2018/9/17.
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * path = "/a/../../b/../c//.//", => "/c"
 * path = "/a//b////c/d//././/..", => "/a/b/c"
 */
public class Leetcode71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        int index = 0, length = path.length();
        while (index < length) {
            if (path.charAt(index) == '/') {
                index++;
                continue;
            } else {
                int end = searchSlashEnd(path, index);
                int temp = end - index;
                if (path.charAt(index) == '.' && temp == 1) {
                } else if (path.charAt(index) == '.' && temp == 2) {
                    if (!stack.isEmpty()) stack.pop();
                } else {
                    stack.push(path.substring(index, end));
                }
                index = end;
            }
        }
        if (stack.isEmpty()) return "/";
        String result = "";//存储结果
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        return result;
    }

    private int searchSlashEnd(String path, int start) {
        for (int i = start; i < path.length(); i++) {
            if (path.charAt(i) == '/') return i;
        }
        return path.length();
    }
}
