class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; ++a) {
            int b = n - a;
            if (!String.valueOf(a).contains("0") && !String.valueOf(b).contains("0"))
                return new int[] { a, b };
        }
        // Given constraints guarantee a solution always exists for n ≥ 2
        throw new IllegalArgumentException("No valid pair found");
    }
}
