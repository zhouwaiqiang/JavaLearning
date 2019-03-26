package com.zhou;

/**
 * Created by 强 on 2018/8/20.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddNum {

    public static void main(String[] args) {
        int a = 10;
        if (a > 15) {
            System.out.println("a 大于15");
        } else if (a <= 10) {
            System.out.println("a 小于10");
        }
        System.out.println("a在10到15之间");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val1 = listToNum(l1);
        int val2 = listToNum(l2);
        int sum = val1 + val2;
        ListNode list = new ListNode(sum%10);
        ListNode last = list;//最后一个节点
        sum = sum / 10;
        while(sum > 0) {
            int num = sum % 10 ;
            ListNode item = new ListNode(num);
            last.next = item;
            last = last.next;
            sum = sum / 10;
        }
        return list;
    }

    private int listToNum(ListNode node) {
        int reverseVal = 0;
        int count = 0; //计数使用
        while(node.next != null) {
            int val = node.val; //获取链表值
            int multip = getPow(10, count);//获取乘法因子
            reverseVal += val*multip;
            count++;//计数加1
            node = node.next;
        }
        return reverseVal;
    }

    private static int getPow(int a, int n) {
        //a的n次方表示
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result*a;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}