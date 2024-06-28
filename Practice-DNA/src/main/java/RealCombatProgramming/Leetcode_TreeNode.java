package RealCombatProgramming;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_TreeNode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return identicalTrees(p, q);
    }

        public boolean identicalTrees(TreeNode a, TreeNode b){
            if (a == null && b == null) return true;
            if (a != null && b != null)
                return (a.val == b.val
                        && identicalTrees(a.left, b.left)
                        && identicalTrees(a.right, b.right));
            return false;
        }

    //https://www.youtube.com/watch?v=jMpi-_NWfZM
    /*public int maxDepth(TreeNode node){
        if(node == null) ? return 0 : return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }*/

    LinkedList sll = new LinkedList();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return sll;
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        sll.add(root.val);
        return sll;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return 1 + leftCount + rightCount;
    }
}
