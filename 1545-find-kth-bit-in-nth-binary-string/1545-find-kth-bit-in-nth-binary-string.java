class Solution {
   
    public char findKthBit(int n, int k) {
        // Convert the numeric result (0 or 1) to character ('0' or '1')
        return (char) ('0' + dfs(n, k));
    }

    private int dfs(int n, int k) {
        // Base case: first position is always '0'
        if (k == 1) {
            return 0;
        }
      
        // Check if k is a power of 2 (middle positions are always '1')
        // k & (k - 1) equals 0 only when k is a power of 2
        if ((k & (k - 1)) == 0) {
            return 1;
        }
      
        // Calculate the total length of S_n: 2^n - 1
        int totalLength = 1 << n;  // 2^n
      
        // If k is in the first half (before middle), recurse on S_(n-1)
        if (k * 2 < totalLength - 1) {
            return dfs(n - 1, k);
        }
    
        return dfs(n - 1, totalLength - k) ^ 1;
    }
}