package org.Basic;

public class BinarySearchTree {

    private TreeNode root;

    private class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void insert(int value){
        root = insert(root, value);
    }

        public TreeNode insert(TreeNode root, int value){
            if(root == null){
                root = new TreeNode(value);
                return root;
            }
            if(value < root.data)
                root.left = insert(root.left, value);
            else
                root.right = insert(root.right, value);
            return root;
        }

    public void inOrder(){
        inOrder(root);
    }

        public void inOrder(TreeNode root){
            if(root == null) return;
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

    public TreeNode search(int key){
        return search(root, key);
    }

        public TreeNode search(TreeNode root, int key){
            if(root == null || root.data == key) return root;
            if(key < root.data)
                return search(root.left, key);
            else
                return search(root.right, key);
        }
    public static void main(String[] args){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        binarySearchTree.insert(1);
        binarySearchTree.inOrder();
        System.out.println("");

        System.out.println("Search 10 in BinaryTree: ");
        if(null != binarySearchTree.search(10))
            System.out.println("Key found !!!");
        else
            System.out.println("Ket not found !!!");
    }
}
