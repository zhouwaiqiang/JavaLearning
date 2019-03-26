package com.leetcode;

/**
 * Created by 强 on 2018/10/15.
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 */
public class Leetcode110 {
    boolean isbanlced = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return isbanlced;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if (Math.abs(left - right) > 1) isbanlced = false;
        return left > right ? left+1 : right+1;
    }
}
