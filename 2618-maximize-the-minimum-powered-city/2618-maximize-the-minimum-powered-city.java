class Solution {
    public long maxPower(int[] stations, int r, long k) {
        int n = stations.length;
        // 1) compute initial power for each city using difference array
        long[] diff = new long[n+1];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            diff[left] += stations[i];
            diff[right + 1] -= stations[i];
        }
        long[] power = new long[n];
        long curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            power[i] = curr;
        }

        // 2) binary search on answer (the minimal power we can guarantee)
        long lo = 0;
        long hi = (long)1e15; // a large upper bound
        while (lo < hi) {
            long mid = lo + ((hi - lo + 1) >> 1);
            if (canMake(power, r, k, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean canMake(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] addDiff = new long[n+1];
        long added = 0;
        long windowAdd = 0;
        for (int i = 0; i < n; i++) {
            windowAdd += addDiff[i];
            long cur = power[i] + windowAdd;
            if (cur < target) {
                long need = target - cur;
                if (need > k) return false;
                k -= need;
                added += need;
                int place = Math.min(n - 1, i + r);
                int left = Math.max(0, place - r);
                int right = Math.min(n - 1, place + r);
                addDiff[left] += need;
                addDiff[right + 1] -= need;
                windowAdd += need;
            }
        }
        return true;
    }
}
