public class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;

        // If n is odd, insert 0 in the array
        if (n % 2 == 1) {
            result[index++] = 0;
        }

        // Then, add pairs (i, -i)
        n /= 2;
        for (int i = 1; i <= n; i++) {
            result[index++] = i;
            result[index++] = -i;
        }

        return result;
    }
}
