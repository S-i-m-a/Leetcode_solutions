class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        long dp = 0; // current length of valid descent ending here

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] == prices[i - 1] - 1) {
                dp++; // extend the previous descent
            } else {
                dp = 1; // start new descent
            }
            ans += dp; // add all subarrays ending at i
        }
        return ans;
    }
}
