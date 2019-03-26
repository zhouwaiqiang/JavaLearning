package com.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 强 on 2018/11/5.
 * 给定一个证整数n，求出它的所有平衡查找树
 */
public class Leetcode95 {
    public List<TreeNode> generateTree(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generate_tree(1, n);
    }

    private static List<TreeNode> generate_tree(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        //选择一个根节点
        for (int i = start; i <= end; i++) {
            List<TreeNode> left_trees = generate_tree(start, i-1);
            List<TreeNode> right_trees = generate_tree(i+1, end);
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    result.add(current_tree);
                }
            }
        }
        return result;
    }
}
