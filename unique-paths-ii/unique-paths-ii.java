class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] o) {
        dp = new int[o.length][o[0].length];
        for(int[] k : dp){
            Arrays.fill(k, -1);
        }
        return dfs(0, 0, o.length, o[0].length, o);
    }

    int dfs(int i, int j , int n , int m, int[][] gp){
        int a = 0;
        if(gp[i][j] == 1) return 0;

        if(i == n-1 && j == m-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(i+1>=0 && i+1<n){
            a += dfs(i+1, j, n, m,gp);
        }

        if(j+1>=0 && j+1<m){
            a += dfs(i, j+1, n, m,gp);
        }
        return dp[i][j] = a;
        
    }
}