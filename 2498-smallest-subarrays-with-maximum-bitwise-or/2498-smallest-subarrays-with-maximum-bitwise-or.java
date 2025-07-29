class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] lastSeen = new int[32];
        
        // Initialize all last seen positions as -1
        Arrays.fill(lastSeen, -1);

        for (int i = n - 1; i >= 0; i--) {
            // Update the last seen positions of the bits in nums[i]
            for (int bit = 0; bit < 32; bit++) {
                if (((nums[i] >> bit) & 1) == 1) {
                    lastSeen[bit] = i;
                }
            }

            // Find the farthest index we need to go to include all set bits
            int farthest = i;
            for (int bit = 0; bit < 32; bit++) {
                if (lastSeen[bit] != -1) {
                    farthest = Math.max(farthest, lastSeen[bit]);
                }
            }

            ans[i] = farthest - i + 1;
        }

        return ans;
    }
}
