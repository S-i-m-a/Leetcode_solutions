import java.util.*;

public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        
        // Try every possible split of the k digits between nums1 and nums2
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] candidate = merge(maxSubArray(nums1, i), maxSubArray(nums2, k - i));
            if (greaterThan(candidate, 0, result, 0)) {
                result = candidate;
            }
        }
        return result;
    }

    private int[] maxSubArray(int[] nums, int k) {
        int[] stack = new int[k];
        int top = 0;
        for (int i = 0; i < nums.length; i++) {
            while (top > 0 && stack[top - 1] < nums[i] && nums.length - i + top > k) {
                top--;
            }
            if (top < k) {
                stack[top++] = nums[i];
            }
        }
        return stack;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, idx = 0;
        
        // Merging two subarrays to form the largest number
        while (i < nums1.length || j < nums2.length) {
            if (greaterThan(nums1, i, nums2, j)) {
                result[idx++] = nums1[i++];
            } else {
                result[idx++] = nums2[j++];
            }
        }
        
        return result;
    }

    private boolean greaterThan(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        // Compare the remaining elements lexicographically
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {6, 7, 5};
        int[] nums2 = {4, 8, 1};
        int k = 3;

        int[] result = solution.maxNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(result));
    }
}
