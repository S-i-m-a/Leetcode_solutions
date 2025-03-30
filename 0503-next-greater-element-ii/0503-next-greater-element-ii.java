import java.util.*;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize result with -1
        Arrays.fill(result, -1);

        // Traverse the array twice (simulate circular behavior)
        for (int i = 0; i < 2 * n; i++) {
            int current = nums[i % n];

            // While stack is not empty and current element is greater than element at index stack.peek()
            while (!stack.isEmpty() && nums[stack.peek()] < current) {
                int index = stack.pop();
                result[index] = current;
            }

            // Only push index during first pass
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}
