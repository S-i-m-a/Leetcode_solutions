public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // result[i] contains the product of all elements to the left of nums[i]
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Now, multiply the result with the product of all elements to the right of nums[i]
        int rightProduct = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProduct *= nums[i + 1];
            result[i] *= rightProduct;
        }

        return result;
    }
}
