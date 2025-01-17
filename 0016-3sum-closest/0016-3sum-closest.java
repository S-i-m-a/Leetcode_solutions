import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);

                if (diff < minDiff) {
                    closestSum = sum;
                    minDiff = diff;
                }

                // Move pointers based on comparison of sum and target
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    // If the sum equals the target, we found the closest sum
                    return sum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println("Closest sum: " + solution.threeSumClosest(nums, target));
    }
}
