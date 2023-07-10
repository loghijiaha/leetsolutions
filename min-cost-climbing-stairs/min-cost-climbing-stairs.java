class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 0;
        dfs(n, n, cost);
        return dp[n];
    }

    int dfs(int i, int n, int[] cost){
        if(i == 0 || i == 1) return dp[i];
        if(dp[i] != -1) return dp[i];
        int a = cost[i-2] + dfs(i-2, n, cost);
        int b = cost[i-1] + dfs(i-1, n, cost);

        return dp[i] = Math.min(a,b);
 
    }
}