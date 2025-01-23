public class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        
        // Move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                if (i != nonZeroIndex) {
                    nums[i] = 0;
                }
                nonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        
        // Printing the result
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
