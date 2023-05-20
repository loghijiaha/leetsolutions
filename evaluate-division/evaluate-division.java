class Pair{
    String op;
    double val;

    Pair(String op, double d){
        this.val = d;
        this.op = op;
    }
}

class Solution {
    Map<String, List<Pair>> mp = new HashMap<>(); 
    public double[] calcEquation(List<List<String>> e, double[] v, List<List<String>> q) {
        //build graph
        for(int i = 0 ; i < e.size();i++ ){
            
            List<String> p = e.get(i);
            if(mp.get(p.get(0)) == null)  mp.put(p.get(0), new ArrayList());
            if(mp.get(p.get(1)) == null)  mp.put(p.get(1), new ArrayList());
            mp.get(p.get(0)).add(new Pair(p.get(1), v[i]));
            mp.get(p.get(1)).add(new Pair(p.get(0), 1/v[i]));
            
        }

        double[] ans = new double[q.size()];
        for(int h = 0; h < q.size(); h++){
            if(mp.get(q.get(h).get(0)) == null ||  mp.get(q.get(h).get(1)) == null){
                ans[h] = -1.0;
                continue;
            }
            ans[h] = dfs(q.get(h).get(0), q.get(h).get(1), new HashSet<String>());
        }
        return ans;
    }

    double dfs(String a, String b, Set<String> vis){
        if(vis.contains(a)) return -1.0;

        if(a.equals(b)) return 1;

        vis.add(a);
        for(Pair p: mp.get(a)){
            if(!vis.contains(p.op)){
               double ans = dfs(p.op, b, vis);
               if(ans != -1) return ans  * p.val;
            }
        }
        return -1;
    }
}