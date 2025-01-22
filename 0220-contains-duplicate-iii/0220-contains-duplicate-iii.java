import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];

            // Check if there's any number in the set such that the absolute difference is at most t
            Long floor = set.floor(num);
            if (floor != null && num - floor <= t) {
                return true;
            }
            Long ceiling = set.ceiling(num);
            if (ceiling != null && ceiling - num <= t) {
                return true;
            }

            // Add the current number to the set
            set.add(num);

            // Maintain the window size of at most k
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
