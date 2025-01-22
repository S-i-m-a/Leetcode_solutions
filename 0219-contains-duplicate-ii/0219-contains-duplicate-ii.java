import java.util.HashSet;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashSet to store elements within the window
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If the element is already in the set, return true
            if (set.contains(nums[i])) {
                return true;
            }
            
            // Add the current element to the set
            set.add(nums[i]);
            
            // If the window size exceeds k, remove the oldest element
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        
        // No duplicates within the given range
        return false;
    }
}
