class Solution {
    int dp[];
    public int numDecodings(String s) {
        dp= new int[s.length()+2];
         return dfs(0,s);
    }

    int dfs(int i, String s){
        if(i >= s.length()) return 1;

        char c = s.charAt(i);
        if(c == '0') return 0;
        if(i == s.length()-1) return 1;
        if(dp[i] != 0) return dp[i];
        
        dp[i+1] = dfs(i+1,s);
        dp[i+2] = 0;
        
        
        
        if( Integer.parseInt(s.substring(i, i+2)) <= 26){
            dp[i+2] += dfs(i+2, s);
        }
        return  dp[i+1] + dp[i+2] ;
    }


}