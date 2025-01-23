public class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1; // The first element is '1'
        if (n == 2) return 1; // "12" has one '1'

        // Initialize the magical string with enough space
        int[] magical = new int[n];
        magical[0] = 1; // First element is '1'
        magical[1] = 2; // Second element is '2'
        magical[2] = 2; // Third element is '2'

        int write = 3;  // Next position to write
        int read = 2;   // Position to determine how many times to repeat

        // Construct the magical string
        while (write < n) {
            int repeat = magical[read++];  // Number of times to repeat
            int value = (magical[write - 1] == 1) ? 2 : 1; // Alternate between 1 and 2

            for (int i = 0; i < repeat && write < n; i++) {
                magical[write++] = value; // Fill the array
            }
        }

        // Count the number of '1's in the first n elements
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (magical[i] == 1) count++;
        }

        return count;
    }
}
