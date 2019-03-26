package com.leetcode;

/**
 * Created by 强 on 2018/9/11.
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 */
public class Leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode last = head;
        int total = 1, count = 1;//total为链表总数，count为计数器
        while (last.next != null) {
            total++;
            last = last.next;
        }
        if (k > total ) k = k % total;
        int searchNum = total - k;
        if (searchNum == 0) return head;//原链表
        System.out.println(total);
        System.out.println("searchNum is:" + searchNum);
        last.next = head;//形成循环链表
        while (true) {
            if (count == searchNum) {
                last = head;
                head = head.next;
                last.next = null;
                return head;
            }
            head = head.next;
            count++;
        }
    }
}
