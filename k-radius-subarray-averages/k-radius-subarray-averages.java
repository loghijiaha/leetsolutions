class Solution {
    public int[] getAverages(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if( 2* k + 1 > n){
            for(int h = 0 ; h < n ; h++){
                ans.add(-1);
            }
            return ans.stream().mapToInt(i -> i).toArray();
        }
        long win_sum = 0;
        for(int i = 0 ; i< n && i < 2*k+1 ; i++ ){
            win_sum+= nums[i];
            if(i < k){
                ans.add(-1);
            }
        }

        int div = 2 *k +1;
        if(k<n){
            ans.add((int)(long)(win_sum/div));
        }
        
        for(int j = k+1  ;  j < n-k ; j++){
            win_sum  = win_sum + nums[j+k] - nums[j-k-1]; 
            ans.add((int)(long)(win_sum/div));
        }
        for(int f = n-k ; f > k && f < n ; f++ ){
            ans.add(-1);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}