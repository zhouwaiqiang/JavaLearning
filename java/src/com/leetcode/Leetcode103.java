package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 强 on 2018/10/29.
 */
public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();//层序遍历队列
        boolean direct = true;//true表示从左向右，false表示从右向左
        if(root != null) queue.add(root);
        else return result;
        while (!queue.isEmpty()) {
            int length = queue.size();//这一行应该有的大小
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i=0; i<length; i++) {
                TreeNode tempNode = queue.poll();//出队
                System.out.println("tempNode is:" + tempNode.val);
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
                temp.add(tempNode.val);
            }
            if (!direct) {
                Collections.reverse(temp);//反向
            }
            result.add(temp);
            direct = !direct;//取反
        }
        return result;
    }
}
