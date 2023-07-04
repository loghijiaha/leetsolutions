class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.compute(i , (key, value) -> value != null ? value +1 : 1);
        }
        int ans = 0;
        for(int k : mp.keySet()){
            if(mp.get(k) > 1) continue;
            ans = k;
            break;
        }
        return ans;
    }
}