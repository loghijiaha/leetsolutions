class Solution {
    int inf = 1000000;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] adj = new int[n][n];
        k = k + 1;
        for(int[] g: adj){
            Arrays.fill(g, inf);
        }
       

        for(int[] s: flights){
            adj[s[0]][s[1]]=s[2];
        }

        int[][][] dp = new int[n][n][k+1];
        for(int e = 0; e <= k; e++){
            for(int i = 0; i< n ; i++){
                for(int j = 0 ; j < n ; j++){
                    dp[i][j][e] = inf;

                    if(e==0 && i==j){
                        dp[i][j][e] = 0;
                    }

                    if( e == 1 && adj[i][j] != inf){
                        dp[i][j][e] = adj[i][j];
                    }

                    if(e>1){
                        for(int x = 0; x< n ; x++){
                            if(adj[i][x] != inf && x != i ){
                                dp[i][j][e] = Math.min(dp[i][j][e] , dp[x][j][e-1] + adj[i][x]);
                            }
                        }
                    }
                }
            }
        }
        
        int ans = inf;
        for(int i: dp[src][dst]){
            ans = Math.min(ans, i);
        }
        System.out.println(Arrays.toString(dp[src][dst]));

        return ans == inf ? -1 : ans;
        
    }
}