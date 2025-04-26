class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int lastInvalid = -1;
        int lastMinK = -1;
        int lastMaxK = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Update the position of the last invalid element
            if (num < minK || num > maxK) {
                lastInvalid = i;
            }

            // Update the position of the last occurrence of minK
            if (num == minK) {
                lastMinK = i;
            }

            // Update the position of the last occurrence of maxK
            if (num == maxK) {
                lastMaxK = i;
            }

            // Calculate the number of valid subarrays ending at the current index
            int validStart = Math.min(lastMinK, lastMaxK);
            if (validStart > lastInvalid) {
                count += validStart - lastInvalid;
            }
        }

        return count;
    }
}
