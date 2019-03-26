package com.leetcode;

/**
 * Created by 强 on 2018/8/28.
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 基本想法就是数数，将两个链表归并，数数的链表采用头插法实现逆序，最后不足这么多位的链表求反（因为头插法是逆序），逆序的逆序就是正序
 */
public class Leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(0);//返回的结果集
        int count = 0;
        ListNode temp = new ListNode(0);//作为合并的一个暂时使用链表
        while (true) {
            if (count == k) {
                result = mergeListNode(result, temp.next);
                temp = new ListNode(0);
                count = 0;
            }
            //加入链表
            ListNode item = new ListNode(head.val);
            item.next = temp.next;
            temp.next = item;
            if (head.next == null && count != k - 1) {
                temp = reverseListNode(temp.next);
                result = mergeListNode(result, temp);
                break;
            } else if (head.next == null && count == k - 1) {
                result = mergeListNode(result, temp.next);
                break;
            }
            head = head.next;
            count++;
        }
        return result.next;
    }

    private static ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode res = l1;
        //索引到最后一个节点
        while (l1.next != null) {
            l1 = l1.next;
        }
        //接入l2
        l1.next = l2;
        return res;
    }

    private static ListNode reverseListNode(ListNode l1) {
        ListNode res = new ListNode(0);
        while(l1 != null) {
            ListNode item = new ListNode(l1.val);
            item.next = res.next;
            res.next = item;
            l1 = l1.next;
        }
        return res.next;
    }
}
