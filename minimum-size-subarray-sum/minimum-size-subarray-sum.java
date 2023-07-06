class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;

        int l=0,r=0, n = nums.length;

        int sum = 0;
        while(r < n){
            sum += nums[r++];
            while(sum >= target){
                sum-=nums[l++];
                ans = Math.min(ans, r+1-l);

            }

        } 

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}