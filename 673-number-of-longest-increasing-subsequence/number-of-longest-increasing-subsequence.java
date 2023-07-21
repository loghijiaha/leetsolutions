class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
     
        int dp[] = new int[n];
        int cnt[] = new int[n];
        Arrays.fill(cnt, 1);
        int ans = 0;
        int len = 0;
        for(int i = 0 ; i < n ; i++){
            int current_max = 1;
            dp[i] = 1;
            for(int j = 0 ; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[i] < dp[j] +1){
                        dp[i] = dp[j] +1;
                        cnt[i] = cnt[j];
                    } else if (dp[i] == dp[j] + 1){
                        cnt[i] += cnt[j];
                    }
                }
                
            }
            len = Math.max(len , dp[i]);

        }
        for(int k = 0 ; k < n ; k++){
            ans+= len == dp[k] ?  cnt[k] : 0; 
        }
        return ans;

        
    }
}