class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int max = 0;
        for(int i=0;i<n;i++){
            boolean[] vis = new boolean[n];
            max = Math.max(max,func(i,bombs,vis));
        }
        return max;
    }
    public int func(int source,int[][] bombs,boolean[] vis){
        vis[source] = true;
        int cnt = 1;
        Queue<int[]> q = new ArrayDeque<int[]>();
        q.add(bombs[source]);
        while(q.size()!=0){
            int x1 = q.peek()[0];
            int y1 = q.peek()[1];
            int r = q.poll()[2];
            for(int i=0;i<bombs.length;i++){
                int x2 = bombs[i][0];
                int y2 = bombs[i][1];
                if(Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2))<=r){
                    if(vis[i]==false){
                        vis[i]=true;cnt++;
                        q.add(bombs[i]);
                    }
                }
            }
        }
        return cnt;
    }
}