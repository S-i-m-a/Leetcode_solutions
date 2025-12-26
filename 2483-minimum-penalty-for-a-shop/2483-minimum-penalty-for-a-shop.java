class Solution {
    public int bestClosingTime(String customers) {
        int ans = 0;
        int profit = 0;
        int maxProfit = 0;

        for (int i = 0; i < customers.length(); i++) {
            // Increase profit for 'Y', decrease for 'N'
            profit += (customers.charAt(i) == 'Y' ? 1 : -1);

            // If profit is higher than any before, update answer
            if (profit > maxProfit) {
                maxProfit = profit;
                ans = i + 1;
            }
        }
        return ans;
    }
}
