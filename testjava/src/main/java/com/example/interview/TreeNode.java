package com.example.interview;

import java.util.Stack;

/**
 * Created by mrz on 18/1/25.
 */

public class TreeNode {
    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", name='" + name + '\'' +
                ", right=" + right +
                '}';
    }

    private TreeNode left;
    private String name;

    public TreeNode(String name) {
        this.name = name;
    }

    private TreeNode right;


    /// 前序遍历
    /// </summary>
    public void PreOrderTraversal()
    {
        if (this != null)
        {
            System.out.print(name+"-");
        }
        if (left != null)
        {
            left.PreOrderTraversal();
        }
        if (right != null)
        {
            right.PreOrderTraversal();
        }
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode("root");
        TreeNode root1l = new TreeNode("root1l");
        TreeNode root1r = new TreeNode("root1r");
        TreeNode root2l = new TreeNode("root2l");
        TreeNode root2r = new TreeNode("root2r");
        TreeNode root5 = new TreeNode("root5");
        treeNode.left = root1l;
        treeNode.right = root1r;
        root1r.left = root2l;
        root1r.right = root2r;
        root2r.left = root5;
treeNode.PreOrderTraversal();
        new Solution().invertTree(treeNode);
        System.out.println("==========");

treeNode.PreOrderTraversal();
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
