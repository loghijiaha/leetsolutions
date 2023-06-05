class Solution {
    int ans = 0;
    int[] vis = new int[200];

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        for(int i =0; i<n;i++){
            if(vis[i] == 1){
                continue;
            }
            ans++;
            dfs(i, isConnected);
        }

        return ans;

    }


    void dfs(int i, int[][] mp){

        if(vis[i] == 1){
            return;
        }

        vis[i] = 1;

        for(int j = 0; j < mp[0].length ; j++){
            if(mp[i][j] == 1) dfs(j, mp);
        }
    }
}