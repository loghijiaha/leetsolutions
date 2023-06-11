class SnapshotArray {
    Map<Integer, List<int[]>> mp;
    int[] tmp;
    Set<Integer> st;

    int count = 0;
    public SnapshotArray(int length) {
        mp = new HashMap<>();
        tmp = new int[length];
        st = new HashSet<>();
        Arrays.fill(tmp, 0);
        
        for(int k = 0 ; k < length ; k++){
            mp.put(k, new ArrayList<>());
        }
    }
    
    public void set(int index, int val) {
        tmp[index] = val;
        st.add(index);
    }
    
    public int snap() {
        for(int i: st){
            mp.get(i).add(new int[]{tmp[i], count});
        }
        st.clear();
        return count++;
        
    }
    
    public int get(int index, int snap_id) {
        List<int[]> rp = mp.get(index);
        for(int i = rp.size()-1; i>=0 ; i--){
            int[] pr = rp.get(i);
            if(pr[1] == snap_id || pr[1] < snap_id){
                return pr[0];
            }else {
                continue;
            }
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */