package com.example.interview;

/**
 * Created by mrz on 18/2/8.
 */

public class RouteCounting {
    /**
     *                    1                                    2
     *               1          2                        1           2
     *            1     2    1     2                   1   2       1
     *           1 2   1    1                         1
     *          1
     */
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        walk(node, node.step);
        walk(node1, node.step);
        System.out.print("count="+route);
    }
    static int route;
    /**
     *
     * @param node 当前步数
     * @param step 之前的累计步数
     */
    private static void walk(Node node, int step) {
        node.left = new Node(1);
        step = node.step + step;
        if (step <= 7) {//不到10步，继续累加
            walk(node.left, step);
            if (step==5){
                route++;
            }
        }
        node.right = new Node(2);
        if (step <= 7) {//不到10步，继续累加
            walk(node.right, step);
            if (step==5){
                route++;
            }
        }


    }

    static class Node {
        Node left;
        Node right;

        public Node(int step) {
            this.step = step;
        }

        int step;
    }
}
