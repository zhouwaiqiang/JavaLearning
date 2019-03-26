package com.leetcode;

import java.util.Arrays;

/**
 * Created by 强 on 2018/10/12.
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        TreeNode root = null;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root = new TreeNode(preorder[0]);
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
            }
        }
        return root;
    }
}
