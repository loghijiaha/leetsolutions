class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        int dx[] = new int[]{0, 1, 0, -1};
        int dy[] = new int[]{1, 0, -1, 0};

        List<Integer> ans = new ArrayList<>();
        int n = m.length, k = m[0].length;
        int x=0, y =0,f=(k*n),i=0;
        while(f>0){


            if(x >=0 && x < n && y >=0 && y < k && m[x][y] != Integer.MIN_VALUE){
                ans.add(m[x][y]);
                m[x][y] = Integer.MIN_VALUE; 
                x+= dx[i];
                y+= dy[i];
                f--;
            }else{
                x-= dx[i];
                y-= dy[i]; 
                i++;
                i = i % 4;
                x+= dx[i];
                y+= dy[i];

            }

                    
        }
        return ans;
    }
}