class Solution {
    public int minimumCost(int[] nums) {
        // nums[0] is always included in the total cost
        int a = nums[0];
        
        // We want the two smallest values among the remaining elements
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // Scan through nums[1..n-1]
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
        }

        return a + min1 + min2;
    }
}
