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
serialize using level-order traversal (bfs)
*/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "n";

        StringBuilder sb = new StringBuilder();

        // perform level order traversal until level is empty
        // track null nodes as well
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("n");
            } else {
                sb.append(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("n")) return null;
        String[] vals = data.split(",");

        // get root
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            String val = vals[index++];
            if (!val.equals("n")) {
                cur.left = new TreeNode(Integer.parseInt(val));
                queue.add(cur.left);
            }

            val = vals[index++];
            if (!val.equals("n")) {
                cur.right = new TreeNode(Integer.parseInt(val));
                queue.add(cur.right);
            }
        }
        return root;
    }
}
