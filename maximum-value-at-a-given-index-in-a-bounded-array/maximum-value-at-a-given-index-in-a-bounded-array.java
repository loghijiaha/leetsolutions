class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l = 0, r = maxSum;

        while(l<r){
            int mid = (l +r +1)/2;

            if(sum(n, index, mid) <= maxSum-n ) l = mid;
            else r = mid-1;
        }

        return l+1;
    }

    public long sum(int n, int index, int value){
        int leftValue = Math.max(value - index, 0);
        int rightValue = Math.max(value - ((n - 1) - index), 0);

        long sumBefore = (long) (value + leftValue) * (value - leftValue + 1) / 2;
        long sumAfter = (long) (value + rightValue) * (value - rightValue + 1) / 2;

        return sumBefore + sumAfter - value ;
    }

   
}