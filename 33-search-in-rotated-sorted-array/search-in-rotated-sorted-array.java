class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while( l <= r ){
            int m = l + (r-l)/2;
            if(target == nums[m]){
                return m;
            }else if (nums[m] >= nums[l]){
                if(nums[l] <= target && nums[m] >= target){
                    r = m-1;
                } else {
                    l = m+1;
                }
            }else {
                if(target <= nums[r] &&  nums[m] <= target){
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
        }

        return -1;

    }

 
}