package com.bjs.leetcode.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * 不能够总是去玩耍吧
 * 该单点正事儿了
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);



        System.out.println(getNumber(l1));

    }

    /**
     * 首先来讲这是一个单向的链表
     * 如何将他逆序的表达出来一个字符串
     * 进而转化为一个数自
     * @param l1
     * @return
     */
    static int getNumber(ListNode l1){

        List<Integer> list = new ArrayList<>();
        int number = 0;
        ListNode middle = l1;
        while(middle.next != null){
           list.add(middle.val);
           middle = middle.next;
        }
        list.add(middle.val);
        for (int i = 0; i <list.size() ; i++) {
            if(i==0){
                number += list.get(i);
            }else{
                int bitnumber = 1;
                for (int j = 0; j <= i-1; j++) {
                    bitnumber = bitnumber*10;
                }
                number += bitnumber*list.get(i);
            }
        }
        return  number;
    }


    /**
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，
     * 它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     *你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersMyAnswer(ListNode l1, ListNode l2) {
        List<Integer> result = new ArrayList<>();
        int resultInt = getNumber(l1)+getNumber(l2);



        return l1;
    }

    /**
     * 标准答案
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
