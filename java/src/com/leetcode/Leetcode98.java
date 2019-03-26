package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 强 on 2018/10/9.
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */
public class Leetcode98 {
    //中序遍历有序
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        mediumTraverse(root, list);
        return isListSort(list);
    }

    private boolean isListSort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i-1)) return false;
        }
        return true;
    }

    private void mediumTraverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            mediumTraverse(root.left, list);
            list.add(root.val);
            mediumTraverse(root.right, list);
        }
    }
}
