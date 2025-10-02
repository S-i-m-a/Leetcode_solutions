class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        // numBottles here represents how many empty bottles we currently have (after drinking them)
        while (numBottles >= numExchange) {
            // Exchange numExchange empty bottles for 1 full bottle:
            numBottles -= numExchange;  // use up that many empties
            numExchange++;              // exchange cost increases by 1 per the problem statement
            ans++;                       // we will drink that new bottle => +1 to answer
            // After drinking, it becomes one empty bottle:
            numBottles += 1;
        }
        return ans;
    }
}
