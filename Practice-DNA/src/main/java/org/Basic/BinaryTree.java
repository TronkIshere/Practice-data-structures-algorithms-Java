package org.Basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first; // root --> first
        first.left = second;
        first.right = third; // second <--- first ---> third

        second.left = fourth;
        second.right = fifth;
    }

    public void preOder(TreeNode root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOder(root.left);
        preOder(root.right);
    }

    //Print preOder but use Stack
    public void preOderUseStack(){
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
    }

    //Print from branch to root
    public void inOder(TreeNode root){
        if(root == null) return;
        inOder(root.left);
        System.out.print(root.data + " ");
        inOder(root.right);
    }

    public void inOderUseStack(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (!stack.isEmpty() || temp != null){
            if(temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    //Print all the Branch then to root
    public void postOder(TreeNode root){
        if(root == null) return;
        postOder(root.left);
        postOder(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrderUseStack(){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while(current != null || !stack.isEmpty()){
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public int findMax(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if(left > result)
            result = left;
        if(right > result)
            result = right;
        return result;
    }

    public void levelOrder(){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
    }


    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        binaryTree.preOder(binaryTree.root);
        System.out.println("");

        System.out.println("Pre-oder binary tree by Stack: ");
        binaryTree.preOderUseStack();
        System.out.println("");

        System.out.println("Post oder binary: ");
        binaryTree.postOder(binaryTree.root);
        System.out.println("");

        System.out.print("Find max number in binary tree: ");
        int result = binaryTree.findMax(binaryTree.root);
        System.out.println(result);
        System.out.println("");
    }
}
