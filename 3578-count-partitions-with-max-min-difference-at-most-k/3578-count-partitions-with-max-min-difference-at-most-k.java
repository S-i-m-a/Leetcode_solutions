class Solution {
    static final long MOD = 1_000_000_007L;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int left = 0;

        for (int r = 0; r < n; r++) {

            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r])
                maxD.pollLast();
            maxD.addLast(r);

            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[r])
                minD.pollLast();
            minD.addLast(r);

            while (!maxD.isEmpty() && !minD.isEmpty() &&
                    nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {

                if (maxD.peekFirst() == left) maxD.pollFirst();
                if (minD.peekFirst() == left) minD.pollFirst();
                left++;
            }

            long sum = pref[r] - (left == 0 ? 0 : pref[left - 1]);
            if (sum < 0) sum += MOD;

            dp[r + 1] = sum % MOD;
            pref[r + 1] = (pref[r] + dp[r + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
