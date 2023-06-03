class Solution {
    public int numOfMinutes(int n, int headID, int[] a, int[] b) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            mp.computeIfAbsent(a[i], k -> new ArrayList<>()).add(i);
        }
        Deque<int[]> v = new ArrayDeque<>();
        v.add(new int[]{headID, b[headID]});
        int ans = 0;
        while (!v.isEmpty()) {
            int[] x = v.pollFirst();
            for (int i : mp.getOrDefault(x[0], new ArrayList<>())) {
                v.add(new int[]{i, x[1] + b[i]});
                ans = Math.max(ans, x[1] + b[i]);
            }
        }
        return ans;
    }
}