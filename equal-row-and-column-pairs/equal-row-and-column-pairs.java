class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> map=new HashMap<>();
        int ans=0;
        for(int []row:grid){
            StringBuilder sb=new StringBuilder();
            for(int i:row){
                sb.append(i).append('#');
            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }
        for(int j=0;j<grid[0].length;j++){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<grid.length;i++){
                sb.append(grid[i][j]).append('#');
            }
            ans+=map.getOrDefault(sb.toString(),0);
        }
        return ans;
    }
}