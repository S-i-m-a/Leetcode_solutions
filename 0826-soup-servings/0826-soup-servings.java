class Solution {
    private Double[][] memo;

    public double soupServings(int n) {
        // For large n, probability effectively ~1 — early return to optimize performance
        if (n >= 4800) {
            return 1.0;
        }

        // Scale down by serving unit (25 ml) to reduce state space
        int N = (n + 24) / 25;
        memo = new Double[N + 1][N + 1];

        return dp(N, N);
    }

    private double dp(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;   // both A & B run out simultaneously
        if (a <= 0) return 1.0;             // A runs out first
        if (b <= 0) return 0.0;             // B runs out first

        if (memo[a][b] != null) {
            return memo[a][b];
        }

        // Consider the four serving choices (scaled by units) equally likely
        memo[a][b] = 0.25 * (
            dp(a - 4, b) +     // Serve 100 ml A, 0 ml B
            dp(a - 3, b - 1) + // Serve 75 ml A, 25 ml B
            dp(a - 2, b - 2) + // Serve 50 ml A, 50 ml B
            dp(a - 1, b - 3)   // Serve 25 ml A, 75 ml B
        );

        return memo[a][b];
    }
}
