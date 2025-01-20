class Solution {
    public int maximumGap(int[] nums) {
        // Edge case: If array has less than 2 elements, no gap exists
        if (nums.length < 2) {
            return 0;
        }
        
        // Step 1: Find the min and max values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        // Step 2: Calculate the bucket size and number of buckets
        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1));  // Minimum bucket size is 1
        int bucketCount = (max - min) / bucketSize + 1;
        
        // Step 3: Create buckets
        int[][] buckets = new int[bucketCount][2];  // Each bucket has a pair: [min, max]
        for (int i = 0; i < bucketCount; i++) {
            buckets[i][0] = Integer.MAX_VALUE;  // Min
            buckets[i][1] = Integer.MIN_VALUE;  // Max
        }
        
        // Step 4: Place each number in the corresponding bucket
        for (int num : nums) {
            int index = (num - min) / bucketSize;
            buckets[index][0] = Math.min(buckets[index][0], num);  // Update bucket min
            buckets[index][1] = Math.max(buckets[index][1], num);  // Update bucket max
        }
        
        // Step 5: Find the maximum gap
        int maxGap = 0;
        int prevMax = min;  // Start from the global minimum
        for (int i = 0; i < bucketCount; i++) {
            if (buckets[i][0] == Integer.MAX_VALUE) {
                // This bucket is empty
                continue;
            }
            // The gap between the previous max and the current bucket's min
            maxGap = Math.max(maxGap, buckets[i][0] - prevMax);
            prevMax = buckets[i][1];  // Update the previous max to the current bucket's max
        }
        
        return maxGap;
    }
}
