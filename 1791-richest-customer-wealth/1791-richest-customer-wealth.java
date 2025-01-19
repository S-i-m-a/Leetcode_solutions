class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] customer : accounts) {
            int currentWealth = 0;

            for (int account : customer) {
                currentWealth += account; // Sum up all accounts for the customer
            }

            maxWealth = Math.max(maxWealth, currentWealth); // Update max wealth if needed
        }

        return maxWealth;
    }
}
