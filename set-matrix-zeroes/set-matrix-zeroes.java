class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> st = new ArrayList<>();
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0) st.add(new int[]{i,j});
            }
        }

        for(int[] p : st){
            int i = p[0], j = p[1];
            Arrays.fill(matrix[i], 0);
            for(int k = 0 ; k< matrix.length ; k++){
                matrix[k][j] = 0;
            }
        }
    }
}