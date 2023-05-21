class Solution {
    int inf = 1000000;
    Deque<int[]> first = new ArrayDeque<>();
    Deque<int[]> second  = new ArrayDeque<>();
    public int shortestBridge(int[][] g) {
        int n = g.length, m = g[0].length;
        int no = 0;
        for(int i = 0; i< n ; i++){
            for(int j = 0 ; j < m; j++){
                if(g[i][j] == 1){
                    dfs(i,j,no,g);
                    no++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        while(!first.isEmpty()){
            int[] f = first.poll();
            for(int[] s: second){
                ans = Math.min(ans, Math.abs((f[0]-s[0])) + Math.abs(f[1]- s[1])-1);
            }
        }
        return ans;
    }

    void dfs(int i , int j, int no,int[][] g){
        if(i<0 || i>= g.length || j < 0 || j>= g[0].length ) return;
        if(g[i][j] == 0) return;

        g[i][j] = 0;

        if(no == 0){
            first.add(new int[]{i,j});
            System.out.println(i + " " + j);
        }
        else{
            second.add(new int[]{i,j});
            System.out.println("second "+ i + " " + j);
        } 

        dfs(i,j+1, no , g);
        dfs(i,j-1, no , g);
        dfs(i+1,j, no , g);
        dfs(i-1,j, no , g);
    }
}