class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        // Dutch National Flag algorithm
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid], move low and mid pointers
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // If the element is 1, move mid pointer
                mid++;
            } else {
                // Swap nums[mid] and nums[high], move high pointer
                swap(nums, mid, high);
                high--;
            }
        }
    }
    
    // Helper function to swap elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
