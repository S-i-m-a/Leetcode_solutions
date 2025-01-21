import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];  // If input is invalid, return an empty array
        }
        
        // Result array to store the maximums
        int[] result = new int[nums.length - k + 1];
        // Deque to store indices of elements, where the values are in decreasing order
        Deque<Integer> deque = new LinkedList<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Remove elements that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove elements from the deque which are smaller than the current element
            // as they will never be needed again
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add current element's index to the deque
            deque.offerLast(i);
            
            // Once we have processed at least 'k' elements, record the max in the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}
