class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (2 * k > n) {
            return false;  // not enough length to fit two non-overlapping subarrays of length k
        }
        
        int increasing = 1;        // length of current strictly increasing run (counting current element)
        int prevIncreasing = 0;    // length of the previous run before a break
        
        // We iterate from index 1 to n−1, comparing nums.get(i) with nums.get(i−1)
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                increasing++;
            } else {
                // sequence broken
                prevIncreasing = increasing;
                increasing = 1;
            }
            
            // At each step, check if we can form two adjacent subarrays of length k:
            // either by splitting within the current run or by combining prev + current runs
            if (increasing / 2 >= k || Math.min(prevIncreasing, increasing) >= k) {
                return true;
            }
        }
        
        return false;
    }
}
