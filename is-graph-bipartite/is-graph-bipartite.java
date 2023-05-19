class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        for(int i = 0 ; i < graph.length ; i++){
            if(vis[i] != 0) continue;
            Deque<Integer> q = new ArrayDeque<>();
            q.add(i);
            vis[i] =1;

            while(!q.isEmpty()){
                int s = q.poll();

                for(int j: graph[s]){
                    if(vis[j] == 0){
                        vis[j] = -vis[s];
                        q.add(j);
                    }else if(vis[s] == vis[j]) return false;
                }
            }

        }
        return true;
    }
}