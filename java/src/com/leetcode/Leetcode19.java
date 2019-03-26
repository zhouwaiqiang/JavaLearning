package com.leetcode;

/**
 * Created by 强 on 2018/8/27.
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index = head;
        int count = 0;
        while (index != null) {
            count++;
            index = index.next;
        }
        int removeIndex = count - n;
        //如果是删除头结点
        if (removeIndex == 0) {
            head = head.next;
            return head;
        }
        //重置
        index = head;
        count = 0;
        while(index != null) {
            if (count == removeIndex - 1) {
                index.next = index.next.next;
                break;
            }
            index = index.next;
            count++;
        }
        return head;
    }
}
