class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the lowest price
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Max profit so far
            }
        }
        return maxProfit;
    }
}
