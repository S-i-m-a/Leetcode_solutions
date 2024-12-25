class Solution {
    public int maxProfit(int[] prices) {
     int max_profit=0;
     int mini=prices[0];
     for (int i=0;i<prices.length;i++){
        int cost=prices[i]-mini;
        max_profit=Math.max(max_profit,cost);
        mini=Math.min(mini,prices[i]);
     }
     return max_profit;
    }
}