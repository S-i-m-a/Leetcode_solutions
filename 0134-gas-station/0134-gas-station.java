class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, tank = 0, startIndex = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If tank is negative, reset startIndex to the next station
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }

        return (totalGas >= totalCost) ? startIndex : -1;
    }
}
