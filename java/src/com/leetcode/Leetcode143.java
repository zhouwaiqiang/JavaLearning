package com.leetcode;

import java.util.Stack;

/**
 * Created by 强 on 2018/11/9.
 */
public class Leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode index = head.next;
        while (index != null) {
            stack.push(index);
            index = index.next;
        }
        index = head.next;
        ListNode p = head;
        int count = 0;
        System.out.println("大小是:" + stack.size());
        while (count < stack.size()) {
            p.next = stack.pop();
            p = p.next;
            System.out.println("第一个：" + p.val);
            p.next = index;
            index = index.next;
            p = p.next;
            count++;
        }
        p.next = null;
    }
}
