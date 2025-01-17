class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            }

            // Determine which part is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target in the left part
                } else {
                    left = mid + 1; // Target in the right part
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target in the right part
                } else {
                    right = mid - 1; // Target in the left part
                }
            }
        }

        return -1; // Target not found
    }
}
