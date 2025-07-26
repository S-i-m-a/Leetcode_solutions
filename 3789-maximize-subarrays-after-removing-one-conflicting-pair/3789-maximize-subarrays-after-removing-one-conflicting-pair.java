class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        // buckets by L = min(a,b)
        List<int[]>[] byL = new List[n + 2];
        for (int i = 1; i <= n; i++) byL[i] = new ArrayList<>();
        for (int id = 0; id < conflictingPairs.length; id++) {
            int a = conflictingPairs[id][0];
            int b = conflictingPairs[id][1];
            if (a > b) { int tmp = a; a = b; b = tmp; }
            byL[a].add(new int[]{b, id});
        }

        long base = 0;
        long[] gain = new long[conflictingPairs.length];
        // track smallest and second smallest R with corresponding ids
        int minR = n + 1, minId = -1;
        int sndR = n + 1, sndId = -1;

        // sweep from i = n down to 1
        for (int i = n; i >= 1; --i) {
            for (int[] p : byL[i]) {
                int R = p[0], cid = p[1];
                if (R < minR) {
                    sndR = minR; sndId = minId;
                    minR = R; minId = cid;
                } else if (R < sndR) {
                    sndR = R; sndId = cid;
                }
            }
            base += (minR - i);
            if (minId != -1) {
                gain[minId] += (sndR - minR);
            }
        }

        long ans = base;
        for (long g : gain) ans = Math.max(ans, base + g);
        return ans;
    }
}
