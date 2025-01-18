public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the target
            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates: skip duplicate elements
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } 
            // Left side is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left part
                } else {
                    left = mid + 1; // Target is in the right part
                }
            } 
            // Right side is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right part
                } else {
                    right = mid - 1; // Target is in the left part
                }
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0)); // Output: true
        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3)); // Output: false
    }
}
