public class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenSum = 0;
        // Calculate the initial sum of even numbers in the array
        for (int num : A) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }

        // Array to store the result after each query
        int[] result = new int[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int value = queries[i][0];
            int index = queries[i][1];
            int oldValue = A[index];

            // Remove old value if it was even
            if (oldValue % 2 == 0) {
                evenSum -= oldValue;
            }

            // Update the value in the array
            A[index] += value;

            // Add the new value if it's even
            if (A[index] % 2 == 0) {
                evenSum += A[index];
            }

            // Store the result for this query
            result[i] = evenSum;
        }

        return result;
    }
}
