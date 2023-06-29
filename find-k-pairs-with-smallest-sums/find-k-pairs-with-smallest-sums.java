class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));

        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int num1 = pair[0];
            int num2 = pair[1];
            int index2 = pair[2];

            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(num1);
            currentPair.add(num2);
            result.add(currentPair);

            if (index2 + 1 < nums2.length) {
                pq.offer(new int[]{num1, nums2[index2 + 1], index2 + 1});
            }

            k--;
        }

        return result;
    }
}