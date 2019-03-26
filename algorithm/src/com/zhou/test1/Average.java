package com.zhou.test1;

import com.zhou.prepare.StdIn;
import com.zhou.prepare.StdOut;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dell on 2017/11/6.
 */
public class Average {
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        for(int i = 0; i<3; i++) {
            System.out.println("移除元素后结果是：");
            printList(test);
            test.remove(test.size()-1);
        }
    }

    private static void printList(ArrayList<Integer> lists) {
        for (Integer list : lists) {
            System.out.print(list + " ");
        }
        System.out.println();
    }
}
