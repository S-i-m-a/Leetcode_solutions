public class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> numsSet = new HashSet<>();
        
        // Add all elements of nums to a HashSet for constant-time lookups
        for (int num : nums) {
            numsSet.add(num);
        }
        
        // Keep doubling the 'original' value as long as it is present in the set
        while (numsSet.contains(original)) {
            original *= 2;
        }
        
        return original;
    }
}
