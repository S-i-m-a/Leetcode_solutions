class Solution {
    public int countPermutations(int[] complexity) {
        final int MOD = 1_000_000_007;
        int n = complexity.length;

        // Check unlock possibility: all other computers must have complexity > complexity[0]
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        // If valid, total permutations = (n-1)! mod MOD
        long result = 1;
        for (int i = 1; i < n; i++) {
            result = (result * i) % MOD;
        }
        return (int) result;
    }
}
