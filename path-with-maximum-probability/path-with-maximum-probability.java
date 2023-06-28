class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] gp = new ArrayList[n];
        for(int i = 0 ; i < gp.length ; i++){
            gp[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < edges.length ; i++){
            int s = edges[i][0];
            int e = edges[i][1];
            gp[s].add(new double[]{e, succProb[i]});
            gp[e].add(new double[]{s, succProb[i]});
        }
        

        // dijikstra

        Queue<double[]> q = new PriorityQueue<>((a,b) -> Double.compare(b[1],a[1]));
        q.offer(new double[]{start, 1.0});
        double[] dis = new double[n];
        dis[start] = 1;
        

        while(!q.isEmpty()){
            double[] idx = q.poll();
            
            for(double[] pair : gp[(int)idx[0]]){
                int dest = (int)pair[0];

                if(dis[(int)idx[0]] * pair[1] > dis[dest]){

                    dis[dest] = dis[(int)idx[0]] * pair[1];
                    q.offer(new double[]{dest, dis[dest]});

                }
            }
        }

        return dis[end];
    }
}