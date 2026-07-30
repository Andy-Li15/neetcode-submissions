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

// assume root, p, and q are not null
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // found ancestor
        if (root.val == p.val || root.val == q.val) return root;
        // ancestor may be on left
        if (p.val <= root.val && q.val <= root.val) {
            if (root.left == null) {
                return root;
            }
            return lowestCommonAncestor(root.left, p, q);
        }
        // ancestor may be on right
        else if (p.val >= root.val && q.val >= root.val) {
            if (root.right == null) {
                return root;
            }
            return lowestCommonAncestor(root.right, p, q);
        }
        // found ancestor
        return root;
    }
}
