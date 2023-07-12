class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[amount+1][coins.length];
        for(int[] f : dp){
            Arrays.fill(f, -1);
        }
        return dfs(0, 0, coins, amount);
    }

    int dfs(int i, int c,  int[] coins,int amount){

        if(amount == i) return 1;
        else if(amount < i) return 0;
        if(c >= coins.length) return 0;

        if(dp[i][c] != -1) return dp[i][c];


        return dp[i][c] = dfs(i, c+1, coins, amount) + 
        dfs(i+coins[c], c, coins, amount);
    }
}