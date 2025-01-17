class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;

        // Calculate the range for binary search
        for (int weight : weights) {
            left = Math.max(left, weight); // Minimum capacity must be at least the heaviest package
            right += weight;              // Maximum capacity is the sum of all weights
        }

        // Binary search to find the minimum capacity that works
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShipInDays(weights, D, mid)) {
                right = mid; // Try a smaller capacity
            } else {
                left = mid + 1; // Increase the capacity
            }
        }

        return left;
    }

    // Greedy function to check if we can ship with the given capacity within D days
    private boolean canShipInDays(int[] weights, int D, int capacity) {
        int daysRequired = 1; // Start with the first day
        int currentWeight = 0;

        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                // If adding this package exceeds the capacity, ship on a new day
                daysRequired++;
                currentWeight = weight;
                if (daysRequired > D) {
                    return false; // More days are required than allowed
                }
            } else {
                currentWeight += weight;
            }
        }

        return true;
    }
}
