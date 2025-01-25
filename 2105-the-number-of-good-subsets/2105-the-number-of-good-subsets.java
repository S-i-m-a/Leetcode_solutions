class Solution {
    public int numberOfGoodSubsets(int[] nums) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        int[] count = new int[31];
        for (int num : nums) {
            ++count[num];
        }

        final int MOD = (int) 1e9 + 7;
        int numPrimes = primes.length;

        long[] dp = new long[1 << numPrimes];
        dp[0] = 1;

        for (int i = 0; i < count[1]; ++i) {
            dp[0] = (dp[0] * 2) % MOD;
        }

        for (int x = 2; x < 31; ++x) {
            if (count[x] == 0 || x % 4 == 0 || x % 9 == 0 || x % 25 == 0) {
                continue;
            }

            int mask = 0;
            for (int i = 0; i < numPrimes; ++i) {
                if (x % primes[i] == 0) {
                    mask |= 1 << i;
                }
            }

            for (int state = (1 << numPrimes) - 1; state > 0; --state) {
                if ((state & mask) == mask) {
                    dp[state] = (dp[state] + count[x] * dp[state ^ mask]) % MOD;
                }
            }
        }

        long answer = 0;
        for (int i = 1; i < 1 << numPrimes; ++i) {
            answer = (answer + dp[i]) % MOD;
        }

        return (int) answer;
    }
}
