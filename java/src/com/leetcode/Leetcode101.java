package com.leetcode;

/**
 * Created by 强 on 2018/10/11.
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 */
public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetrical(root, root);
    }

    private static boolean isSymmetrical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val == node2.val) return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
        else return false;
    }
}
