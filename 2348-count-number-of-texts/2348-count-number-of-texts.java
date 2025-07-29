class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 100_010;
    private static final long[] f = new long[MAX];
    private static final long[] g = new long[MAX];

    static {
        // Precompute DP arrays:
        // f[i]: number of ways for group length i for digits with 3 letters (2–6,8)
        // g[i]: number of ways for digits with 4 letters (7 & 9)
        f[0] = f[1] = 1; f[2] = 2; f[3] = 4;
        g[0] = g[1] = 1; g[2] = 2; g[3] = 4;
        for (int i = 4; i < MAX; i++) {
            f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % MOD;
            g[i] = (g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD;
        }
    }

    public int countTexts(String pressedKeys) {
        long result = 1;
        int n = pressedKeys.length();
        for (int i = 0; i < n; ++i) {
            char c = pressedKeys.charAt(i);
            int j = i;
            // Count contiguous block of the same digit
            while (j + 1 < n && pressedKeys.charAt(j + 1) == c) {
                j++;
            }
            int cnt = j - i + 1;
            // Choose f or g depending on digit
            long ways = (c == '7' || c == '9') ? g[cnt] : f[cnt];
            result = (result * ways) % MOD;
            i = j;
        }
        return (int) result;
    }
}
