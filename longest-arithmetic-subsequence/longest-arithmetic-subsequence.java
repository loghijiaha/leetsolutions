class Solution {
    public int longestArithSeqLength(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[][] dp  = new int[n][1056];

     
        for(int i = 1; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                int diff = nums[i]-nums[j] + 501;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                ans = Math.max(dp[i][diff], ans);
                
            }
        }

        return ans+1;        
    }
}