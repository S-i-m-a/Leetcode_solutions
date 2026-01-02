class Solution {
    public int repeatedNTimes(int[] nums) {
        // Create a HashSet to store unique elements
        // Initial capacity is set to n/2 + 1 for optimization
        Set<Integer> seenNumbers = new HashSet<>(nums.length / 2 + 1);
      
        // Iterate through the array
        for (int i = 0; ; ++i) {
            // Try to add current element to the set
            // add() returns false if element already exists
            if (!seenNumbers.add(nums[i])) {
                // Found the duplicate element that appears n times
                return nums[i];
            }
        }
    }
}
