package com.leetcode;

/**
 * Created by 强 on 2018/10/15.
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Given the sorted linked list: [-10,-3,0,5,9],

     One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

     0
     / \
     -3   9
     /   /
     -10  5
 */
public class Leetcode109 {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode last) {
        if (head == null || head == last) return null;
        ListNode temp = head, mid = head;//temp用来遍历链表，mid表示查找的链表中间数据
        while (temp != last && temp.next != last) {
            temp = temp.next.next;
            mid = mid.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(head, mid);
        root.right = helper(mid.next, last);
        return root;
    }
}
