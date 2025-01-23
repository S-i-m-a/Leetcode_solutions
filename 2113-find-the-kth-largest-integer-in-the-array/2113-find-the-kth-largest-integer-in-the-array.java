import java.util.*;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // Convert the array of strings to a list of integers, sorting them by value.
        Arrays.sort(nums, (a, b) -> {
            // First compare the lengths of the strings, because longer strings represent larger numbers.
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            // If lengths are the same, compare the strings lexicographically.
            return b.compareTo(a);
        });
        
        // Return the k-th largest element.
        return nums[k - 1];
    }
}

