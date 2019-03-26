package com.leetcode;

import java.util.*;

/**
 * Created by 强 on 2018/10/12.
 */
public class Leetcode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        int count = 0, index = 0, level = 0;//count计算轮次，index计数器, level表示第level+1层
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();//用于映射第几层与层数的个数的映射
        map.put(level, 1);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) queue.add(root);
        else return result;
        while (!queue.isEmpty()) {
            if (index == 0) temp.clear();//清空
            if (index < map.get(level)) {
                TreeNode tempNode = queue.poll();//出队
                if (tempNode.left != null) {
                    queue.add(tempNode.left);//左子树入队
                    count++;
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);//右子树入队
                    count++;
                }
                temp.add(tempNode.val);
                index++;
                if (queue.isEmpty()) result.add(0, new ArrayList(temp));
            } else {
                result.add(0, new ArrayList(temp));
                index = 0;
                level++;
                map.put(level, count);
                count = 0;
            }
        }
        return result;
    }
}
