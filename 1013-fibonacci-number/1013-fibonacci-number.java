class Solution {
    private int[] dp = new int[31]; // Constraint: 0 <= n <= 30

    public int fib(int n) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        return dp[n] = fib(n - 1) + fib(n - 2);
    }
}
