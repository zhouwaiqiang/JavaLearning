package com.leetcode;

import java.util.LinkedList;

/**
 * Created by 强 on 2018/10/16.
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, given the following tree:
 */
public class Leetcode114 {
    TreeNode pre = null;
    public void flatten(TreeNode root) {

        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
