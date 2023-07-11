class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        return dfs(0,0,grid);
    }

    int dfs(int i, int j, int[][] g){    
        if (i >= g.length || j >= g[0].length){
            return Integer.MAX_VALUE;
        }
        if(i == g.length -1 && j == g[0].length-1) return g[i][j];
        if(dp[i][j] != 0) return dp[i][j];

        int ans = Math.min(dfs(i+1,j,g), dfs(i,j+1,g));
        return dp[i][j] =  ans + g[i][j];
    }
}