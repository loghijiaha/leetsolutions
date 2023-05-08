class Solution {
    public int diagonalSum(int[][] mat) {
        int n= mat.length, m= mat[0].length;
        int ans = 0;
        int piv = 0;
        for(int i=0,j=0,l=n-1,k=0; i<n && j<m && l>=0 && k<m; i++,j++,k++,l--){
            ans += (mat[i][j] + mat[l][k]);
            if(i==l && k==j) piv = mat[i][j];
        }
        return ans - piv;
    }
}