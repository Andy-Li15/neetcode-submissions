/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int diameter = depth(root.left) + depth(root.right);

        int other = Math.max(diameterOfBinaryTree(root.right), 
            diameterOfBinaryTree(root.left));
        return Math.max(diameter, other);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

}
