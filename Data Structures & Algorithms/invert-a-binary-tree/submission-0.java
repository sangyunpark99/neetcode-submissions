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
    public TreeNode invertTree(TreeNode root) {

        dfs(root);
        return root;
    }

    private void dfs(TreeNode cur) {
        if(cur == null) return;

        TreeNode temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;

        dfs(cur.left);
        dfs(cur.right);
    }
}
