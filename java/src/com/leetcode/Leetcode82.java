package com.leetcode;

/**
 * Created by 强 on 2018/9/24.
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class Leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        boolean headIsRepeat = false;
        //首先头结点去重
        while (head != null) {
            ListNode cur = head.next;
            while (cur != null && cur.val == head.val) {
                headIsRepeat = true;
                cur = cur.next;
            }
            if (headIsRepeat) {
                head = cur;
                headIsRepeat = false;
            }
            else break;
        }
        ListNode pre = head;
        boolean isRepeat = false;//判断是否重复
        while (pre != null) {
            if (pre.next != null) {
                ListNode index = pre.next;
                int matchVal = index.val;
                index = index.next;
                while (index != null && index.val == matchVal) {
                    isRepeat = true;
                    index = index.next;
                }
                if (isRepeat) {
                    pre.next = index;
                    isRepeat = false;
                } else {
                    pre = pre.next;
                }
                continue;
            }
            pre = pre.next;
        }
        return head;
    }
}
