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
        System.out.print("count="+recursiveWalk(totalstep));

    }
    static int route;
    static int totalstep = 50;
    /**
     *
     * @param node 当前步数
     * @param step 之前的累计步数
     */
    private static void walk(Node node, int step) {
        node.left = new Node(1);
        step = node.step + step;
        if (step <= totalstep) {//不到10步，继续累加
            walk(node.left, step);
            if (step==totalstep){
                route++;
            }
        }
        node.right = new Node(2);
        if (step <= totalstep) {//不到10步，继续累加】

            walk(node.right, step);
            if (step==totalstep){
                route++;
            }
        }
    }


    private static int recursiveWalk(int step){
        if (step<1){
            return 0;
        }
        if (step==2){
            return 2;
        }
        if (step==1){
            return 1;
        }

        return recursiveWalk(step-1)+recursiveWalk(step-2);
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
