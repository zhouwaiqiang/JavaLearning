package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 强 on 2018/10/12.
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 Note: A leaf is a node with no children.

 Example:

 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 Return:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class Leetcode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        if (root==null) return result;
        getPathSumList(result, temp, root, sum, 0);
        return result;
    }

    private void getPathSumList(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum, int total) {
        if (root.left == null && root.right == null && (total + root.val) == sum) {
            temp.add(root.val);
            result.add(new ArrayList(temp));
            temp.remove(temp.size()-1);
            return;
        }
        if (root.left == null && root.right == null && (total + root.val) != sum) {
            return;
        }
        if (root.left != null) {
            temp.add(root.val);
            getPathSumList(result, temp, root.left, sum, total + root.val);
            temp.remove(temp.size()-1);
        }
        if (root.right != null) {
            temp.add(root.val);
            getPathSumList(result, temp, root.right, sum, total + root.val);
            temp.remove(temp.size()-1);
        }
    }
}
