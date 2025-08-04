class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int placed = 0;

        // Try placing each fruit in the first available basket
        for (int fruit : fruits) {
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruit) {
                    used[j] = true;
                    placed++;
                    break; // move to next fruit
                }
            }
        }

        // Number of unplaced fruit types
        return n - placed;
    }
}
