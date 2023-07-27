class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long stTime=0;
        long edTime=0;
        for(int i=0;i<batteries.length;i++){
            edTime+=batteries[i];
        }
        long ans=0;
        while(stTime<=edTime){
            long mid=stTime + (edTime-stTime)/2;
            if(isPossible(n,batteries,mid)){
                ans=mid;
                stTime=mid+1;
            } else {
                edTime=mid-1;
            }
        }
        return ans;
    }
    public boolean isPossible(int n,int batteries[],long mid){
        long time=0;
        for(int i=0;i<batteries.length;i++){
            if(batteries[i]<=mid){
                time+=batteries[i];
            } else {
                time+=mid;
            }
        }
        return time>= mid*n;
    }
}