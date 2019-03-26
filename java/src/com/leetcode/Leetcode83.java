package com.leetcode;

/**
 * Created by 强 on 2018/9/26.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Input: 1->1->2
 * Output: 1->2
 */
public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode index = head;
        while(index != null) {
            int firstVal = index.val;
            if (index.next != null) {
                ListNode search = index.next;
                boolean marked = false;//标记这个数据是否重复
                while (search != null && search.val == firstVal) {
                    marked = true;
                    search = search.next;
                }
                if (marked) {
                    index.next = search;
                }
            }
            index = index.next;
        }
        return head;
    }
}
