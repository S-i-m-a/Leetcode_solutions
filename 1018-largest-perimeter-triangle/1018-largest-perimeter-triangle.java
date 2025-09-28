import java.util.Arrays;

public class Solution {
    public int largestPerimeter(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        // After sorting, try triplets from the end
        for (int i = nums.length - 1; i >= 2; i--) {
            int c = nums[i];
            int b = nums[i - 1];
            int a = nums[i - 2];
            // Check the triangle condition: a + b > c
            if ((long)a + b > c) {
                return a + b + c;
            }
        }
        return 0;
    }
}
