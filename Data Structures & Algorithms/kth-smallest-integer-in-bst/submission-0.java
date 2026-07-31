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
inorder traversal until reaching kth node
*/
class Solution {

    int index = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || index == k) return 0;
        kthSmallest(root.left, k);
        index++;
        if (index == k) result = root.val;
        kthSmallest(root.right, k);
        return result;
    }
}


