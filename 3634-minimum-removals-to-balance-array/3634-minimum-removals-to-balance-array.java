class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int left = 0;
        int maxKeep = 0;

        for (int right = 0; right < n; right++) {
            while (left <= right && (long) nums[right] > (long) nums[left] * k) {
                left++;
            }
            maxKeep = Math.max(maxKeep, right - left + 1);
        }

        return n - maxKeep;
    }
}