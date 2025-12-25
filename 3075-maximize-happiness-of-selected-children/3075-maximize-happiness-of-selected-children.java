class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // Sort the happiness array in ascending order
        Arrays.sort(happiness);
      
        // Initialize the total happiness sum
        long totalHappiness = 0;
      
        // Get the length of the happiness array
        int n = happiness.length;
      
        // Select k children with highest happiness values (from the end of sorted array)
        for (int i = 0; i < k; i++) {
            // Calculate the adjusted happiness for the current child
            // Each previously selected child reduces happiness by 1
            int adjustedHappiness = happiness[n - i - 1] - i;
          
            // Add the adjusted happiness to total (minimum 0 if happiness becomes negative)
            totalHappiness += Math.max(adjustedHappiness, 0);
        }
      
        return totalHappiness;
    }
}