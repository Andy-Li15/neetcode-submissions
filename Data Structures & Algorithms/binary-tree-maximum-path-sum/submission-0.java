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

/*
Run dfs with postorder traversal (process left and right first)
find max path ending at children to find max path of parent
*/

class Solution {

    int best = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return best;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null) return 0;
        // return root.val if root has no children
        if (root.left == null && root.right == null) {
            best = Math.max(best, root.val);
            return root.val;
        }
        
        // get max path sum ending at left and right
        // if path is negative, do not include (set as 0)
        int left = Math.max(maxPathSumHelper(root.left), 0);
        int right = Math.max(maxPathSumHelper(root.right), 0);

        // calculate potential new best containing left and/or right path
        best = Math.max(best, left + right + root.val);

        // return max path ending at root
        return Math.max(left + root.val, right + root.val);
    }
}



