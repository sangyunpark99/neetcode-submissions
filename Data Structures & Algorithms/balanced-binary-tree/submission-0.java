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

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    private int dfs(TreeNode cur) {
        if(cur == null) return 0;   

        int left = dfs(cur.left);
        int right = dfs(cur.right);

        if(Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return Math.max(left, right) + 1;
    }
}
