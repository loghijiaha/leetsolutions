class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] g : dp){
            Arrays.fill(g, -1);
        }
        return dfs(0,0,text1,text2,dp);
    }


    int dfs(int i, int j, String t1, String t2, int[][] dp){

        if(i == t1.length() && j == t2.length()) return 0;

        if(i < t1.length() && j < t2.length() && dp[i][j] != -1) return dp[i][j];

        int ans = 0;

        if(i < t1.length() && j < t2.length() && t1.charAt(i) == t2.charAt(j)){
            ans = 1 + dfs(i+1, j+1, t1, t2, dp);
        } else {
            if(i < t1.length()) ans = Math.max(ans , dfs(i+1, j, t1, t2, dp));
            if(j < t2.length()) ans = Math.max(ans , dfs(i, j+1, t1, t2, dp));
        }

        if(i < t1.length() && j < t2.length()){
            dp[i][j] = ans;
        }

        return ans;

    }
}