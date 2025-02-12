class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // Edge case: empty array
        
        int uniqueIndex = 0; // Pointer for the unique elements
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) { 
                uniqueIndex++; 
                nums[uniqueIndex] = nums[i]; // Place the new unique value
            }
        }
        
        return uniqueIndex + 1; // The count of unique elements
    }
}
