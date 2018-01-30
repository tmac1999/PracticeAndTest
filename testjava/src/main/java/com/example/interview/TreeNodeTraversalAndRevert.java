package com.example.interview;

import java.util.Stack;

/**
 * Created by mrz on 18/1/25.
 */

public class TreeNodeTraversalAndRevert {
    public static class TreeNode{
        @Override
        public String toString() {
            return "TreeNode{" +
                    "left=" + left +
                    ", name='" + name + '\'' +
                    ", right=" + right +
                    '}';
        }

        private TreeNode left;
        private TreeNode right;
        private String name;
        public TreeNode(String name) {
            this.name = name;
        }
    }






    /// 前序遍历
    /// </summary>
//    public void PreOrderTraversal() {
//        if (this != null) {
//            System.out.print(name + "-");
//        }
//        if (left != null) {
//            left.PreOrderTraversal();
//        }
//        if (right != null) {
//            right.PreOrderTraversal();
//        }
//    }
    //https://www.cnblogs.com/llguanli/p/7363657.html

    /**
     *      1
     *    2    3
     *   4 5    6
     *    7 8
     */
    /**
     *
     前序遍历：1  2  4  5  7  8  3  6

     中序遍历：4  2  7  5  8  1  3  6

     后序遍历：4  7  8  5  2  6  3  1

     层次遍历：1  2  3  4  5  6  7  8
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode("1");
        TreeNode t2 = new TreeNode("2");
        TreeNode t3 = new TreeNode("3");
        TreeNode t4 = new TreeNode("4");
        TreeNode t5 = new TreeNode("5");
        TreeNode t6 = new TreeNode("6");
        TreeNode t7 = new TreeNode("7");
        TreeNode t8 = new TreeNode("8");
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t5.left = t7;
        t5.right = t8;

        //t1.PreOrderTraversal();
        //new Solution().invertTree(t1);
        //System.out.println("==========");

        //t1.PreOrderTraversal();
        PreOrderTraversal(t1);
        System.out.println("==========");
        inOrderTraversal(t1);
        System.out.println("==========");
        postOrderTraversal(t1);
    }

    public static void PreOrderTraversal(TreeNode t){
        if (t==null){
            return;
        }
        System.out.print(t.name+"-");
        if (t.left!=null){
            PreOrderTraversal(t.left);
        }
        if (t.right!=null){
            PreOrderTraversal(t.right);
        }


    }
    public static void inOrderTraversal(TreeNode t){
        if (t==null){
            return;
        }

        //if (t.left!=null)
        inOrderTraversal(t.left);
        //}
        System.out.print(t.name+"-");
        //if (t.right!=null){
        inOrderTraversal(t.right);
       // }


    }
    public static void postOrderTraversal(TreeNode t){
        if (t==null){
            return;
        }

        if (t.left!=null){
            postOrderTraversal(t.left);
        }
        if (t.right!=null){
            postOrderTraversal(t.right);
        }
        System.out.print(t.name+"-");

    }


    public static class Solution {
        /**
         * 翻转二叉树
         *
         * @param root 二叉树的根
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

        public TreeNode non_recursion(TreeNode root) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.add(root);
            TreeNode pop = stack.pop();
            return pop;

        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //Looks at the object at the top of this stack without removing it from the stack.
            TreeNode node = stack.peek();
            stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}
