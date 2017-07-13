package com.example;

/**
 * Created by mrz on 17/7/13.
 */

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8


 */
public class LeetCode1 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);


        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        ListNode listNode = new Solution().addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode.val + "=" + listNode.next.val + "=" +listNode.next.next.val);
//        LinkedList<Object> objects = new LinkedList<>();
//        objects.getLast();
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        boolean hasNext() {
            return next != null;
        }
    }

    public static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            ListNode temp1 = l1;
//            ListNode temp2 = l2;
//            ListNode resultTemp = null;
//            ListNode result;
//            int i = l1.val + l2.val;
//            if (i > 9) {
//                result = new ListNode(i % 10);
//                temp1.next.val++;
//            } else {
//                result = new ListNode(i);
//            }
//            temp1 = l1.next;
//            temp2 = l2.next;
//            result.next = resultTemp;
//            while (temp1.hasNext()) {
//                int tempNum = temp1.val + temp2.val;
//                ListNode listNode;
//                if (tempNum > 9) {
//                    listNode = new ListNode(tempNum % 10);
//
//                    temp1.next.val++;
//                } else {
//                    listNode = new ListNode(tempNum);
//                }
//                resultTemp = listNode;
//                temp1 = temp1.next;
//                temp2 = temp2.next;
//                resultTemp = resultTemp.next;
//
//            }
//            return result;
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

}
