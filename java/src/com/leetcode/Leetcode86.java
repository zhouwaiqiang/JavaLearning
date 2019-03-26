package com.leetcode;

/**
 * Created by 强 on 2018/9/27.
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class Leetcode86 {
    public ListNode partition(ListNode head, int x) {
        //链表的快排
        
        ListNode index = head;//索引变量
        ListNode smallNode = new ListNode(0);//比x小的节点列表
        ListNode bigNode = new ListNode(0);//比x大的节点列表
        ListNode smallIndex = smallNode;
        ListNode bigIndex = bigNode;
        while (index != null) {
            if (index.val < x) {
                smallIndex.next = index;
                smallIndex = smallIndex.next;
            } else {
                bigIndex.next = index;
                bigIndex = bigIndex.next;
            }
            index = index.next;//遍历查找值
        }
        bigIndex.next = null;//最后一个置位为空
        smallIndex.next = bigNode.next;//大的连接到小的后面
        return smallNode.next;//返回链表的表头
    }
}
