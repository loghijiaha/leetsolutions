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
    int max = 0;
    public int maxLevelSum(TreeNode root) {
        int ans[] = new int[10004];
        int tmp = Integer.MIN_VALUE,res = 0;
        dfs(root, 1, ans);
        for(int i=1; i<= max ; i++){
            if(ans[i] > tmp){
                tmp = ans[i];
                res = i;
            }
        }
        return res;
    }

    void dfs(TreeNode root, int level, int[] ans){
        if(root == null) return;
        max = Math.max(max, level);
        ans[level] += root.val;
        dfs(root.left, level+1, ans);

        dfs(root.right, level+1, ans);
    }
}