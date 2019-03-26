package com.offer;

import java.util.Stack;

/**
 * Created by 强 on 2018/12/16.
 * 给定一个链表的头结点，现在需要从尾到头反过来打印出每个节点的值。
 * 如果按照正常的打印，遍历输出即可，但是题中要求是从尾到头打印，可以很自然的想到改变链表，采用头插法将链表反转然后遍历可以得到结果。
 * 但是很有可能给定条件是在不改变链表顺序的情况下实现，那么这个方法就不行了。
 * 从后到前其实就是一个先进后出的过程，可以采用栈的方式实现（也可以采用递归，但是递归链表过长会导致栈溢出）。
 */
public class Demo5 {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node last = head;
        Node temp = null;
        for (int i = 1; i <6; i++) {
            temp = new Node(i);
            last.next = temp;
            last = temp;
        }
        printListRecursive(head);
    }

    private static void printListRecursive(Node head) {
        if (head == null) return;
        if (head.next != null) printList(head.next);
        System.out.print(head.val + " ");
    }


    private static void printList(Node head) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.val + " ");
        }
    }

}
