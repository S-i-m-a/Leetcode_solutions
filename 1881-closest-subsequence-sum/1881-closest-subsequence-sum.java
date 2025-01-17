import java.util.*;

class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = n / 2;

        // Divide the array into two parts
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, n);

        // Generate all possible sums for left and right parts
        List<Integer> leftSums = generateSums(left);
        List<Integer> rightSums = generateSums(right);

        // Sort rightSums for binary search
        Collections.sort(rightSums);

        int closest = Integer.MAX_VALUE;

        // Iterate through each sum in leftSums
        for (int leftSum : leftSums) {
            int remaining = goal - leftSum;

            // Find the closest sum in rightSums to 'remaining'
            int idx = Collections.binarySearch(rightSums, remaining);
            if (idx < 0) {
                idx = -idx - 1;
            }

            // Check the closest value and update 'closest'
            if (idx < rightSums.size()) {
                closest = Math.min(closest, Math.abs(remaining - rightSums.get(idx)));
            }
            if (idx > 0) {
                closest = Math.min(closest, Math.abs(remaining - rightSums.get(idx - 1)));
            }
        }

        return closest;
    }
    private List<Integer> generateSums(int[] nums) {
        List<Integer> sums = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n subsets

        for (int subset = 0; subset < totalSubsets; subset++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((subset & (1 << i)) != 0) {
                    sum += nums[i];
                }
            }
            sums.add(sum);
        }

        return sums;
    }
}
