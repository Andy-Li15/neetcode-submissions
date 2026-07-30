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
Use a queue
track size of queue before processing level
process level, adding nodes of next level
repeat until queue empty
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // first level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // size of level
        int size = 1;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // process level and update queue
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            result.add(level);
            size = queue.size();
        }
        return result;
    }
}
