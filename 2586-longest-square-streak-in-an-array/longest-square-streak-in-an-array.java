class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        int ans = -1;
        Set<Long> s = new HashSet<>();
        for(int i = 0 ; i < n; i++){
            s.add((long)nums[i]);
        }

        for(int k : nums){
            long m = k;
            int count = 1;

            while(s.contains(m*m)){
                    count++;
                    m = m*m;

                
            }

            if(count >= 2){
                    ans = Math.max(count, ans);

            }

            
        }

        return ans;
    }
}