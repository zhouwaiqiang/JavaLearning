package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 强 on 2018/9/27.
 * 中序遍历
 */
public class Leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        TreeNode index = root;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || index != null) {
            if (index != null) {
                stack.push(index);
                index = index.left;
            } else {
                index = stack.peek().right;
                result.add(stack.pop().val);
            }
        }
        return result;
    }

    private List<Integer> backup(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();
        inorderTraversal(result, root);
        return result;
    }

    private void inorderTraversal(List<Integer> res, TreeNode node) {
        if (node.left != null) inorderTraversal(res, node.left);
        res.add(node.val);
        if (node.right != null) inorderTraversal(res, node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) {
        this.val = x;
    }
}
