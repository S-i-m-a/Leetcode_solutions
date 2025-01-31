import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int start = nums[0];
        
        for (int i = 1; i <= nums.length; i++) {
            // Check if we've reached the end of the array or if the current number is not consecutive
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));  // Single number range
                } else {
                    result.add(start + "->" + nums[i - 1]);  // Range from start to nums[i-1]
                }
                
                // Update start for the next range
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution sr = new Solution();
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(sr.summaryRanges(nums));  // Output: ["0->2", "4->5", "7"]
    }
}
