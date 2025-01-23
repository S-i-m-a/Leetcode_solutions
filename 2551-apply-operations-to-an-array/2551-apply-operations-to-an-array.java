public class Solution {
    public int[] applyOperations(int[] nums) {
        // Apply the operation: Double the first element and set second to 0 if equal
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Move all non-zero elements to the front
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                if (i != nonZeroIndex) {
                    nums[i] = 0;
                }
                nonZeroIndex++;
            }
        }
        
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 0, 4, 0};
        int[] result = solution.applyOperations(nums);

        // Printing the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
