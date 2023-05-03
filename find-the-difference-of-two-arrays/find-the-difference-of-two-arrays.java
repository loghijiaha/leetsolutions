class Solution {
    public <T> List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> n1 = IntStream.of(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> n2 = IntStream.of(nums2).boxed().collect(Collectors.toSet());

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
    
        for(int i: nums1){
            if(!n2.contains(i) && !l1.contains(i)){
                l1.add(i);
            }
        }
        ans.add(l1);

        for(int i: nums2){
            if(!n1.contains(i) && !l2.contains(i)){
                l2.add(i);
            }
        }
        ans.add(l2);

        return ans;
    }
}