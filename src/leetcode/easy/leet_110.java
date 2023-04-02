package leetcode.easy;

import java.util.Arrays;

public class leet_110 {

    public static void main(String[] args){
        System.out.println(isBalanced());
    }


    /*
    class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if(Math.abs(leftDepth - rightDepth) > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode node) {
        if (node == null){
            return 0;
        }

        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
     */

    public static boolean isBalanced() {
        /*TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3,new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));*/

        /*TreeNode root = new TreeNode(1,
                new TreeNode(2 ,new TreeNode(4,new TreeNode(8), null) ,new TreeNode(5)),
                new TreeNode(3, new TreeNode(6) ,null));*/
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15) ,new TreeNode(7)));



        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return Math.abs(leftDepth - rightDepth) <= 1;
    }

    private static int getDepth(TreeNode node) {
        if (node == null){
            return 0;
        }

        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    static class TreeNode {
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
}


