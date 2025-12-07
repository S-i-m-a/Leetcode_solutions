class Solution {
    public int countOdds(int low, int high) {
        // Number of odd numbers from 0..high   → (high + 1) / 2  
        // Number of odd numbers from 0..(low-1) → low / 2  
        // Difference gives odd numbers in [low, high]
        return (high + 1) / 2 - (low / 2);
    }
}
