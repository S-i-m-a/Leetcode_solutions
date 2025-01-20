class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;  // To track the total amount of gas
        int totalCost = 0; // To track the total cost required
        int currentTank = 0;  // To track the gas in the current trip
        int startingStation = 0;  // To track the starting station
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i] - cost[i];
            
            // If we cannot make it from current station, reset the starting station
            if (currentTank < 0) {
                startingStation = i + 1;
                currentTank = 0;
            }
        }
        
        // If total gas is less than total cost, there's no valid solution
        return totalGas < totalCost ? -1 : startingStation;
    }
}
