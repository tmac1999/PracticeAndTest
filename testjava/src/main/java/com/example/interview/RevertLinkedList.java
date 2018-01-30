package com.example.interview;

import java.util.ArrayList;

/**
 * Created by mrz on 18/1/25.
 */

public class RevertLinkedList {
    static class Node {
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public Node(String name) {
            this.name = name;
        }

        String name;
    }

    public static void main(String[] args) {
        Node node = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");
        Node node8 = new Node("8");
        Node node9 = new Node("9");
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        print(node);

        Node node1 = revert2_diy(node);
        System.out.println("==========================");
        print(node1);
    }

    private static void print(Node node) {
        while (node.next != null) {
            System.out.print(node + "----");
            node = node.next;

        }
        System.out.print(node);
    }

    private static Node revert(Node node) {
        Node last;
        Node temp;
        ArrayList<Node> nodes = new ArrayList<>();
        while (node.next != null) {
            nodes.add(node);
            node = node.next;
        }
        nodes.add(node);
        for (int i = nodes.size() - 1; i > 0; i--) {
            nodes.get(i).next = nodes.get(i - 1);
            if (i == 1) {
                nodes.get(i - 1).next = null;
            }
        }
        return node;
    }

    private static void revert1(Node node) {
        Node newNode = null;
        Node temp = null;
        while (node != null) {
            if (newNode == null) {
                newNode = node;
                newNode.next = null;
            } else {
                node = node.next;
                node.next = newNode;
            }
        }
    }

    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static Node revert2(Node head) {
        if (head == null)
            return head;
        Node pre = head;// 上一结点
        Node cur = head.next;// 当前结点
        Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.next;
            cur.next = pre;// 反转指针域的指向

            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.next = null;

        return pre;
    }


    public static Node revert2_diy(Node head) {
        if (head == null) {
            return head;
        }

        Node pre = head;
        Node cur = head.next;
        head.next = null;
        Node temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public static Node revert_recursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        } else if (head.next.next != null) {
            return revert_recursion(head.next);
        }

        return head;
    }


}
