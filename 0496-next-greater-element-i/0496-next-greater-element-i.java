import java.util.*;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 in reverse to find next greater elements
        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];

            // Pop elements from the stack that are less than or equal to current
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // If stack is empty, no greater element exists
            nextGreater.put(current, stack.isEmpty() ? -1 : stack.peek());

            // Push current onto the stack
            stack.push(current);
        }

        // Build result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.get(nums1[i]);
        }

        return result;
    }
}
