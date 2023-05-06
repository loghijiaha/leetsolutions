class Solution {
      int mod = (int)1e9+7;
    long power(long x,long y){
       if(y==1) return x;
       if(y==0) return 1;
       long ans =1;
       if(y%2==0){
           ans = power(x,y/2);
           ans*=ans;
       }
       else{
           ans = power(x,y-1);
           ans*=x;
       }
       return ans%mod;
    }
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            if(nums[low]+nums[high]<=target){
                ans+=power(2,high-low);
                ans = ans%mod;
                low++;
            }
            else{
                high--;
            }
        }
        return ans%mod;
    }
}