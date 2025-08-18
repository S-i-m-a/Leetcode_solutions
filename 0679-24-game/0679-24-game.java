class Solution {
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int num : cards) {
            nums.add((double) num);
        }
        return backtrack(nums);
    }

    private boolean backtrack(List<Double> nums) {
        int n = nums.size();
        if (n == 1) {
            return Math.abs(nums.get(0) - 24.0) < EPSILON;
        }

        // Try every pair (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Double> next = new ArrayList<>();
                // Collect the other numbers
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        next.add(nums.get(k));
                    }
                }

                double a = nums.get(i), b = nums.get(j);
                List<Double> candidates = generateCandidates(a, b);

                for (double candidate : candidates) {
                    next.add(candidate);
                    if (backtrack(next)) {
                        return true;
                    }
                    next.remove(next.size() - 1);
                }
            }
        }

        return false;
    }

    private List<Double> generateCandidates(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (Math.abs(b) > EPSILON) results.add(a / b);
        if (Math.abs(a) > EPSILON) results.add(b / a);
        return results;
    }
}
