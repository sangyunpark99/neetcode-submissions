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

    private int answer = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return answer;
    }

    private int dfs(TreeNode cur) {
        if(cur == null) return 0;
        int left = dfs(cur.left);
        int right = dfs(cur.right);
        answer = Math.max(answer, left + right);
        return Math.max(left, right) + 1;
    }
}
