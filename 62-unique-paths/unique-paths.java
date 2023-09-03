class Solution {
    int[] dx = { 0, 1};
    int[] dy = { 1, 0};
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        return dfs(0, 0, m, n, dp);
    }

    int dfs(int i,int j, int m, int n, int[][] dp){
        if(i==(n-1) && j==(m-1)) return 1;
        if(dp[i][j] != 0) return dp[i][j];
        int ans = 0;
        for(int k = 0 ; k < 2 ; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= 0 && x < n && y>=0 && y<m ){
                ans += dfs(x,y,m,n,dp); 
            }
        }
        return dp[i][j] = ans;

    }
}