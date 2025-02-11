class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num; // Change candidate
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        return candidate;
    }
}
