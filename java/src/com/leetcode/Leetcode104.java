package com.leetcode;

/**
 * Created by 强 on 2018/10/12.
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return 1 + maxDepth(root.right);
        else if (root.right == null) return 1 + maxDepth(root.left);
        else {
            int leftDepth = 1 + maxDepth(root.left);
            int rightDepth = 1 + maxDepth(root.right);
            return leftDepth > rightDepth ? leftDepth : rightDepth;
        }
    }
}
