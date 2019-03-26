package com.leetcode;

import java.util.Arrays;

/**
 * Created by 强 on 2018/10/12.
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 */
public class Leetcode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        TreeNode root = null;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                root = new TreeNode(postorder[postorder.length-1]);
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i+1, inorder.length),
                        Arrays.copyOfRange(postorder, i, postorder.length-1));
            }
        }
        return root;
    }
}
