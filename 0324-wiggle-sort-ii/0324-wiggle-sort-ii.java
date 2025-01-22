import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Create a copy of the sorted array
        int[] sorted = nums.clone();

        int n = nums.length;

        // Step 3: Fill the wiggle pattern
        int left = (n - 1) / 2; // Middle element for the odd indices
        int right = n - 1;      // Largest element for the even indices

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[left--]; // Fill even indices with smaller half
            } else {
                nums[i] = sorted[right--]; // Fill odd indices with larger half
            }
        }
    }
}
