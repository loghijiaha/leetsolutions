class Solution {
    public int maxProfit(int[] prices) {
        int piv = Integer.MAX_VALUE;
        int ans = 0;
        for( int i = 0 ; i < prices.length; i++){
            if ( piv > prices[i]) piv = prices[i];
            else continue;
            for(int j = i+1; j < prices.length ; j++){
                ans = Math.max(ans, prices[j]-prices[i]);
            }
        }
        return ans;
    }
}