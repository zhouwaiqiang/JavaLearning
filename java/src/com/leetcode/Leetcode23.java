package com.leetcode;

/**
 * Created by 强 on 2018/8/27.
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Input:
 *    [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 *   ]
 *   Output: 1->1->2->3->4->4->5->6
 *  解法：利用两个链表的合并，对整个链表数组进行遍历，每次合并两个链表并将合并的链表写入到第二个链表的位置
 *  第一个链表位置置空，保证内存的释放
 */
public class Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        for (int i = 0; i < lists.length - 1; i++) {
            ListNode result = mergeTwoLists(lists[i], lists[i+1]);
            //覆写lists[i + 1]
            lists[i + 1] = result;
            lists[i] = null;
        }
        return lists[lists.length - 1];
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int first = 0;//用于存储result中的第一个变量值
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 !=null) {
            first = l2.val;
            l2 = l2.next;
        } else if (l2 == null && l1 !=null) {
            first = l1.val;
            l1 = l1.next;
        } else {
            first = l1.val <= l2.val? l1.val : l2.val;
            if (first == l1.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        ListNode result = new ListNode(first);
        ListNode index = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                ListNode item = new ListNode(l2.val);
                index.next = item;
                index = index.next;
                l2 = l2.next;
            } else if(l2 == null) {
                ListNode item = new ListNode(l1.val);
                index.next = item;
                index = index.next;
                l1 = l1.next;
            } else if(l1.val <= l2.val) {
                ListNode item = new ListNode(l1.val);
                index.next = item;
                index = index.next;
                l1 = l1.next;
            } else {
                ListNode item = new ListNode(l2.val);
                index.next = item;
                index = index.next;
                l2 = l2.next;
            }
        }
        return result;
    }
}
