class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // Total bottles we can drink — start with all the full bottles we have initially
        int totalDrunk = numBottles;
        // empty: how many empty bottles we currently have (initially, after drinking all)
        int empty = numBottles;
        
        // While we have enough empty bottles to exchange for at least one full bottle
        while (empty >= numExchange) {
            int newFull = empty / numExchange;        // how many new full bottles we get
            totalDrunk += newFull;                    // we will drink them
            // update empty: leftover empties + new empties from the bottles we just drank
            empty = (empty % numExchange) + newFull;
        }
        
        return totalDrunk;
    }
}
