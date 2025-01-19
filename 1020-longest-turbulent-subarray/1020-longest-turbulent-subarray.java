class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // Edge case: if the array has less than two elements, it's not turbulent
        if (arr.length < 2) return arr.length;
        
        // Initialize variables to store the length of current "up" and "down" subarrays
        int up = 1, down = 1;
        int maxLength = 1;
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                // If the current element is greater than the previous one, it's an "up"
                up = down + 1;
                down = 1;
            } else if (arr[i] < arr[i - 1]) {
                // If the current element is less than the previous one, it's a "down"
                down = up + 1;
                up = 1;
            } else {
                // If the current element is equal to the previous one, reset both
                up = 1;
                down = 1;
            }
            
            // Update the maximum length
            maxLength = Math.max(maxLength, Math.max(up, down));
        }
        
        return maxLength;
    }
}
