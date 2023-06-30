class Solution {
    int[] dx = {0, -1 , 1 ,0};
    int[] dy = {-1, 0, 0 , 1};
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int l = 0; int r = row*col;
        int ans = 0;
        while(l<r-1){
            int mid = l + (r-l)/2;
            System.out.println(isGo(cells, mid, row, col));
        
            if(isGo(cells, mid, row, col)){
                l = mid;
                ans = l;
            }else{
                r = mid;
            }
        }
        return ans+1;
    }

    boolean isGo(int[][] cell, int mid, int row, int col){
        int[][] tmp = new int[row][col];
            for(int i = 0; i <= mid ; i++){
                tmp[ cell[i][0]-1 ][ cell[i][1] -1] = 1;
        }
        boolean ans = false;
        for(int j = 0; j< col ; j++){
            
            ans |= dfs(row, col, 0, j, tmp);
        }
        return ans;

    }

    boolean dfs(int row, int col, int i, int j, int[][] gd){
        if( gd[i][j] == 1) return false;
        if( i == row-1) return true;
        gd[i][j] = 1;

        boolean ans = false;
        for(int k = 0 ; k < 4 ; k++){
            if(i+dx[k] >= 0 && i+dx[k] <row && j+dy[k] >=0 && j+dy[k] < col ){
                ans |= dfs(row, col, i+dx[k] , j+dy[k], gd);
            }
            
        }
        return ans;


    }
}