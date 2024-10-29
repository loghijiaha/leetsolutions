class Solution {
    public int maxMoves(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i =0 ; i <n ; i++){
            dp[i][0] = 1;
        }
        for(int j = 1 ; j < m ;j++ ){
            for (int i =0; i< n  ; i++){
                int up = 0,lvl = 0,bot = 0;
                if(i > 0) {

                    if (grid[i][j] > grid[i-1][j-1] &&  dp[i-1][j-1] > 0) {
                        up = Integer.max(dp[i][j],  dp[i-1][j-1] +1);
                    } else {
                        up = 0;
                    }
                    
                } 
                
                if (i < n - 1) {
                    if (grid[i][j] > grid[i+1][j-1] &&  dp[i+1][j-1]>0) {
                        bot = Integer.max(dp[i][j],  dp[i+1][j-1] +1);
                    } else {
                        bot  = 0 ;
                    }
                    
                } 
                
                if (j > 0) {
                    if (grid[i][j] > grid[i][j-1] &&  dp[i][j-1] > 0) {
                        lvl = Integer.max(dp[i][j], dp[i][j-1]+1);
                    } else {
                        lvl = 0;
                    }   
                }
            

                dp[i][j] = Integer.max(lvl , Math.max(up, bot));
                ans = Integer.max(dp[i][j]-1, ans);          
            }

        }

        return ans;

    }
}