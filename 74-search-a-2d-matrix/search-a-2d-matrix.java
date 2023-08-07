class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l = 0 , r = n*m-1;

        while(l<=r){

            int mid = l + (r-l)/2;

            int mid_x = mid/m;
            int mid_y = mid%m;
            if(matrix[mid_x][mid_y] == target){
                return true;
            }else if(matrix[mid_x][mid_y] > target){
                r  = mid-1;
            }else{
                l = mid +1;
            }

        }

        return false;
    }
}