class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for placing non-val elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move valid element to the left
                k++; // Increase count of valid elements
            }
        }

        return k; // New length of modified array
    }
}
