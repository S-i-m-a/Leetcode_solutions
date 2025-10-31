class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] result = new int[2];
        int[] count = new int[101]; // since 0 <= nums[i] < n and n ≤ 100 per constraints
        int idx = 0;
        for (int x : nums) {
            if (++count[x] == 2) {
                result[idx++] = x;
                if (idx == 2) {
                    break;
                }
            }
        }
        return result;
    }
}
