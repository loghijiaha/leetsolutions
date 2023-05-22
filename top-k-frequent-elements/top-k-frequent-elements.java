class Solution {
    public int[] topKFrequent(int[] n, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i : n){
            mp.compute(i, (p,v) -> v == null ? 1 : v+1);
        }
 
        List<Integer> ans = new ArrayList<>();
        Queue<int[]> p = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        for(int i : mp.keySet()){
            p.offer(new int[]{i, mp.get(i)});
        }

        while(k-->0){
            ans.add(p.poll()[0]);
        }
        return ans.stream().mapToInt(x->x).toArray();


    }
}