class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length; // Length of the baskets
        Map<Integer, Integer> fruitCountMap = new HashMap<>(); // A map to store the count difference of fruits between baskets
      
        // Count the difference between the two baskets
        for (int i = 0; i < n; ++i) {
            fruitCountMap.merge(basket1[i], 1, Integer::sum);  // Increment count for the current fruit in basket1
            fruitCountMap.merge(basket2[i], -1, Integer::sum); // Decrement count for the current fruit in basket2
        }
      
        int minFruitValue = Integer.MAX_VALUE; // Initialize the minimum fruit value
        List<Integer> fruitDifferences = new ArrayList<>(); // List to store absolute differences
      
        // Analyze the map to find out the absolute difference and minimum fruit value
        for (var entry : fruitCountMap.entrySet()) {
            int fruit = entry.getKey(), count = entry.getValue();
            if (count % 2 != 0) { // If count is odd, there's no way to balance, return -1
                return -1;
            }
            for (int i = Math.abs(count) / 2; i > 0; --i) {
                fruitDifferences.add(fruit);  // Add the fruit differences
            }
            minFruitValue = Math.min(minFruitValue, fruit); // Update the minimum fruit value if necessary
        }
      
        Collections.sort(fruitDifferences); // Sort the list of differences
      
        int m = fruitDifferences.size(); // Size of the list of differences
        long totalCost = 0; // Initialize the total cost
      
        // Calculate the minimum cost of balancing the baskets
        for (int i = 0; i < m / 2; ++i) {
            totalCost += Math.min(fruitDifferences.get(i), minFruitValue * 2); // Take the minimum of the current fruit difference and double of min fruit value
        }
      
        return totalCost; // Return the total minimum cost
    }
}
