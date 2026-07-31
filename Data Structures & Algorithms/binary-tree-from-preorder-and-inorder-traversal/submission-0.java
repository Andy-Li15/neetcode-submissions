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
    int preIndex;
    HashMap<Integer, Integer> nodeToIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        preIndex = 0;
        TreeNode root = new TreeNode(preorder[preIndex]);

        nodeToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodeToIndex.put(inorder[i], i);
        }

        int inIndex = nodeToIndex.get(preorder[preIndex]);

        preIndex++;
        root.left = buildTree(preorder, inorder, 0, inIndex - 1);
        root.right = buildTree(preorder, inorder, inIndex + 1, preorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int l, int r) {
        if (preIndex >= preorder.length) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        
        int inIndex = nodeToIndex.get(preorder[preIndex]);

        if (inIndex < l || inIndex > r) return null;
        preIndex++;
        root.left = buildTree(preorder, inorder, l, inIndex - 1);
        root.right = buildTree(preorder, inorder, inIndex + 1, r);
        return root;
    }
}






