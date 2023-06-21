class Solution {
    public long minCost(int[] nums, int[] cost) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        for(int u: nums){
            mx = Math.max(mx, u);
            mn = Math.min(mn, u);
        }

        long ans = 0;
        while(mn < mx ){
            int mid  = mn + (mx-mn)/2;
            long w1 = calc(mid, nums, cost);
            long w2 = calc(mid+1, nums, cost);
            if(w1 >= w2){
                mn = mid+1;
                ans = w2;
            } else {
                mx = mid;
                ans = w1;
            }
        }
        return ans;
    }

    public long calc(int n ,int[] nums,  int[] costs){
        int l = nums.length;
        long sum = 0;
        for(int i=0; i< l ; i ++ ){
            sum += 1L * Math.abs(nums[i] - n) * costs[i];
        }
        return sum;
    }
}