class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp = new int[n+1];
        return dfs(n);
    
    }

    public int  dfs(int n) {
        if (n==1) return 1;
        if(n==2) return 2;
        if(dp[n] != 0) return dp[n];
        dp[n] = dfs(n-2) + dfs(n-1);
        return dp[n];
    }
}