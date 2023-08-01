class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        dfs(n,k,1,new ArrayList<>());
        return ans;
    }

    void dfs(int n, int k, int i, List<Integer> l){

        if(k == 0 ){
            ans.add(l);
            return;
        }
        if(i>n) return;
      
        l.add(i);
        dfs(n , k-1, i+1, new ArrayList<>(l));
        l.remove(l.size()-1);
        dfs(n ,k, i+1, new ArrayList<>(l));
    }
}