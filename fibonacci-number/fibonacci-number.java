class Solution {
    int dp[] = new int[34];
    public int fib(int n) {
        if( n ==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        if(dp[n] != 0) return dp[n];
        return dp[n] = fib(n-2) + fib(n-1);
    }
}