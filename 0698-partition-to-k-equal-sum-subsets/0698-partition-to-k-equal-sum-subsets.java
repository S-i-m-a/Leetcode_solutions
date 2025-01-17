class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is not divisible by k, it's impossible to partition
        if (totalSum % k != 0) {
            return false;
        }

        int target = totalSum / k;
        boolean[] visited = new boolean[nums.length];

        // Sort the array in descending order (optional optimization)
        Arrays.sort(nums);
        reverse(nums);

        return backtrack(nums, visited, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] visited, int k, int currentSum, int start, int target) {
        // If all k subsets are formed, return true
        if (k == 0) {
            return true;
        }

        // If the current subset reaches the target sum, start a new subset
        if (currentSum == target) {
            return backtrack(nums, visited, k - 1, 0, 0, target);
        }

        // Try adding each number to the current subset
        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= target) {
                visited[i] = true;
                if (backtrack(nums, visited, k, currentSum + nums[i], i + 1, target)) {
                    return true;
                }
                visited[i] = false; // Backtrack
            }
        }

        return false;
    }

    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
