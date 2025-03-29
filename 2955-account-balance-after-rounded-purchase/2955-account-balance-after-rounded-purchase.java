class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int roundedAmount = (purchaseAmount + 5) / 10 * 10;
        return 100 - roundedAmount;
    }
}
