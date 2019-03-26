package com.leetcode;

/**
 * Created by 强 on 2018/8/22.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val1 = l1.val;
        l1 = l1.next;
        int val2 = l2.val;
        l2 = l2.next;
        int val = (val1 + val2)%10;
        int carry = (val1 + val2)/10;//进位值
        ListNode list = new ListNode(val);
        ListNode last = list;
        int count = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                val1 = 0;
                val2 = l2.val;
            } else if (l2 == null) {
                val2 = 0;
                val1 = l1.val;
            } else {
                val1 = l1.val;
                val2 = l2.val;
            }
            int sum = val1 + val2 + carry;
            ListNode item = new ListNode(sum % 10);
            last.next = item;
            last = last.next;
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            ListNode item1 = new ListNode(1);
            last.next = item1;
            last = last.next;
        }
        return list;
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        this.val = x;
    }
}

