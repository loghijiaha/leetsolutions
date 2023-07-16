class Solution {
    int[][] dp;
    public int maxValue(int[][] events, int k) {
        int ans = 0;
        Arrays.sort(events, (a,b) -> a[0]==b[0] ? a[1]-b[1]: a[0]-b[0]);
        dp = new int[events.length][k+1];
        System.out.println(Arrays.deepToString(events));

        return dfs(0, events.length, events, k ,-1);
    }


    int dfs(int i, int n, int[][] gp, int s, int prev){
        if(i >= n || s == 0) return 0;


        if (dp[i][s] != 0) return dp[i][s];
        
        int pick = 0;
        int o;
        for(o=i; o<n; o++){
            if(gp[o][0] > gp[i][1]){
                break;
            }
        }
        
    
        pick =  gp[i][2] + dfs(o, n, gp, s-1, i);
    
        
        int not = dfs(i+1, n , gp, s, prev);
        return dp[i][s] = Math.max(pick , not);
    }
}