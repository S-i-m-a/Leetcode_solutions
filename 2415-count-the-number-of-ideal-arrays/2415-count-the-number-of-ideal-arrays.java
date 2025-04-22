class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX = 10015; // Increased to prevent out-of-bounds
    long[][] comb = new long[MAX][20];

    public int idealArrays(int n, int maxValue) {
        computeCombinations(n + 14, 14);

        int[] spf = new int[maxValue + 1];
        for (int i = 2; i <= maxValue; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= maxValue; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }

        long res = 0;
        for (int num = 1; num <= maxValue; num++) {
            int x = num;
            Map<Integer, Integer> primeExponents = new HashMap<>();

            while (x > 1) {
                int p = spf[x];
                int count = 0;
                while (x % p == 0) {
                    x /= p;
                    count++;
                }
                primeExponents.put(p, primeExponents.getOrDefault(p, 0) + count);
            }

            long ways = 1;
            for (int exp : primeExponents.values()) {
                ways = ways * comb[n + exp - 1][exp] % MOD;
            }
            res = (res + ways) % MOD;
        }

        return (int) res;
    }

    void computeCombinations(int n, int k) {
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= k && j <= i; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }
    }
}
