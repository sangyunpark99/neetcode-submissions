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
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode cur) {
        if(cur == null) return 0;
        System.out.println(cur.val);
        return Math.max(dfs(cur.left), dfs(cur.right)) + 1; 
    }
}
