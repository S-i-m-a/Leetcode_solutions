import java.util.*;

public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Step 1: Remove duplicates and sort the array
        TreeSet<Integer> uniqueSet = new TreeSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }
        int[] unique = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) {
            unique[index++] = num;
        }

        // Step 2: Sliding window to find the max range of consecutive elements
        int maxFit = 0;
        int j = 0;
        for (int i = 0; i < unique.length; i++) {
            while (j < unique.length && unique[j] < unique[i] + n) {
                j++;
            }
            maxFit = Math.max(maxFit, j - i);
        }

        // Step 3: Calculate minimum operations
        return n - maxFit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{4, 2, 5, 3})); // Output: 0
        System.out.println(solution.minOperations(new int[]{1, 2, 3, 5, 6})); // Output: 1
    }
}
