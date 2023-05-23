class KthLargest {
    List<Integer> l;

    int x = 0;
    int k ;
    public KthLargest(int k, int[] nums) {
        l = new ArrayList<>();

        this.k = k;
        for(int i : nums){

                l.add(i);

        }
    }
    
    public int add(int val) {
        l.add(val);
        if(k<=l.size()){

            l.sort((a,b)-> b-a);
            x = l.get(k-1);
        }
        return x;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */