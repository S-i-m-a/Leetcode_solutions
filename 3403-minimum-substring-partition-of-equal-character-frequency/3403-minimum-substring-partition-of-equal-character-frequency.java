class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            int distinct = 0, maxFreq = 0;

            // consider all substrings ending at i, starting from j
            for (int j = i; j >= 0; j--) {
                int idx = cs[j] - 'a';
                if (count[idx] == 0) distinct++;
                count[idx]++;
                maxFreq = Math.max(maxFreq, count[idx]);

                int totalLen = i - j + 1;
                // check balance: totalLen == distinct * maxFreq
                if (totalLen == distinct * maxFreq) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
}
