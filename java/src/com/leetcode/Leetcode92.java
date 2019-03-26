package com.leetcode;

/**
 * Created by 强 on 2018/9/27.
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class Leetcode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode front = new ListNode(0);
        front.next = head;
        int count = 1;
        ListNode index = front;
        while (index != null) {
            if (count == m) {
                ListNode tempList = new ListNode(0);
                ListNode reverseIndex = index.next;
                ListNode tempListLast = null;
                boolean marked = true;
                while (count <= n) {
                    //头插法
                    ListNode item = new ListNode(reverseIndex.val);
                    item.next = tempList.next;
                    tempList.next = item;
                    if (marked) {
                        tempListLast = tempList.next;//获得此链表最后一个节点
                        marked = false;
                    }
                    //索引
                    reverseIndex = reverseIndex.next;
                    count++;
                }
                //合并
                index.next = tempList.next;
                tempListLast.next = reverseIndex;
                return front.next;
            }
            index = index.next;
            count++;
        }
        return front.next;
    }
}
