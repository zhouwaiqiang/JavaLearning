package com.leetcode;

/**
 * Created by 强 on 2018/10/12.
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 * Example:
 * Given the below binary tree and sum = 22,
 */
public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return isPathSum(root, sum, 0);
    }

    private boolean isPathSum(TreeNode root, int sum, int total) {
        if (root.left == null && root.right == null && (total + root.val) == sum) return true;
        if (root.left == null && root.right == null && (total + root.val) != sum)  return false;
        if (root.left != null) {
            if (isPathSum(root.left, sum, total + root.val)) return true;
        }
        if (root.right != null) {
            return isPathSum(root.right, sum, total + root.val);
        }
        return false;
    }
}
