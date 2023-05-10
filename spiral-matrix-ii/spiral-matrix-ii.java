class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];
        int i=0,j=0;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int f = 0;
        int k = 0;
        while(f<n*n){
            if(i>=0 && i<n && j>=0 && j<n && ans[i][j] == 0){
                ans[i][j] = ++f;
                i += dx[k];
                j += dy[k];
            }else{
                i -= dx[k];
                j -= dy[k];
                k = (k+1)%4;
                i += dx[k];
                j += dy[k];
            }
                System.out.println(j);


            
        }
        return ans;
    }
}