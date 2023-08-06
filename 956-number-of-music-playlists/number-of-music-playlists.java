class Solution {
    long[][] dp;
    int mod = 1000000007;
    public int numMusicPlaylists(int n, int goal, int k) {
        dp = new long[goal+1][n+1];
        for (long[] cur : dp){
            Arrays.fill(cur, -1);
        }
        return (int)dfs(n, goal, k);
    }

    public long dfs(int n, int goal, int k){
        if (n == 0 && goal == 0){
            return 1;
        }
        if (n == 0 || goal == 0){
            return 0;
        }
        if (dp[goal][n] != -1){
            return dp[goal][n];
        }
        // # of possible playlists with repeat a previous song
        long repeat = dfs(n, goal-1, k)*Math.max(n-k, 0);
        // # of possible playlists with new song selected
        long newsong = dfs(n-1, goal-1, k)*n;
        // make sure the result does not overflow the integer
        return dp[goal][n] = (int)(repeat%mod+newsong%mod)%mod;
    }
}