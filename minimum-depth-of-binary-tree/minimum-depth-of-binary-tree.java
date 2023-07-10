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
    int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        dfs(root,1);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    void dfs(TreeNode root, int curr){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans = Math.min(ans, curr);
        }
        dfs(root.left, curr+1);
        dfs(root.right, curr+1);
    }
}