package com.leetcode;

/**
 * Created by 强 on 2018/11/12.
 */
public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode start, ListNode last) {
        //第一个节点就是空或者下一个节点为空直接返回
        if (start == null || start.next == null) return start;
        //如果两个相等则表示此时将这个节点的next置空返回
        if (start == last) {
            start.next = null;
            return start;
        }
        //获取链表中间节点
        ListNode middle = getMiddle(start, last);
        //获取链表中间的下一个节点
        ListNode middleNext = middle.next;
        //左侧链表排序
        ListNode left = sortList(start, middle);
        //右侧链表排序
        ListNode right = sortList(middleNext, last);
        ListNode result = mergeSort(left, right);
        return result;
    }

    private ListNode mergeSort(ListNode first, ListNode second) {
        ListNode front = new ListNode(0);
        ListNode pre = front;//插入节点的前一个节点索引
        while (first != null || second != null) {
            if (first == null) {
                pre.next = second;
                break;
            } else if (second == null) {
                pre.next = first;
                break;
            } else {
                if (first.val < second.val) {
                    pre.next = first;
                    first = first.next;
                    pre = pre.next;
                } else {
                    pre.next = second;
                    second = second.next;
                    pre = pre.next;
                }
            }
        }
        return front.next;
    }

    private ListNode getMiddle(ListNode start, ListNode last) {
        ListNode slow = start, fast = start;//快慢二指针获取中间节点
        while (fast != last && fast.next != last) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
