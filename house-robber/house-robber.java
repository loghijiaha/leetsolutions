class Solution {

    int dp[];
    public int rob(int[] nums) {
        int n = nums.length;
    
        dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(0, n, nums);
    }

    int dfs(int i,int n, int[] nums){
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];

        int a = nums[i] + dfs(i+2 , n, nums);
        int b = dfs(i+1, n, nums);

        return dp[i] = Math.max(a, b);
    }
}