class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the number of subarrays that include arr[i]
            int startCount = i + 1;
            int endCount = n - i;

            // Total occurrences of arr[i] in all subarrays
            int totalOccurrences = startCount * endCount;

            // Only consider occurrences in odd-length subarrays
            int oddOccurrences = (totalOccurrences + 1) / 2;

            // Add the contribution of arr[i] to the total sum
            totalSum += oddOccurrences * arr[i];
        }

        return totalSum;
    }
}
