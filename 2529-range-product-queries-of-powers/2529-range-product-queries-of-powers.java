class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int[] productQueries(int n, int[][] queries) {
        // 1. Build the 'powers' array: the 2^i components that sum to n
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) { // up to 2^30 since n ≤ 1e9
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }

        int m = powers.size();
        // 2. Build prefix products modulo MOD
        long[] prefix = new long[m + 1];
        prefix[0] = 1;
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = (prefix[i] * powers.get(i)) % MOD;
        }

        // 3. Answer each query using prefix products and modular inverse
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long prod = prefix[r + 1] * modInverse(prefix[l]) % MOD;
            result[i] = (int) prod;
        }

        return result;
    }

    // Fast modular exponentiation for computing inverse
    private long modInverse(long x) {
        long res = 1, power = MOD - 2;
        x %= MOD;
        while (power > 0) {
            if ((power & 1) == 1) res = (res * x) % MOD;
            x = (x * x) % MOD;
            power >>= 1;
        }
        return res;
    }
}
