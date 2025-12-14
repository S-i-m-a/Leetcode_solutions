class Solution {
    public int numberOfWays(String corridor) {
        long MOD = 1_000_000_007;
        long ans = 1;
        int seats = 0;
        int plants = 0;

        for (int i = 0; i < corridor.length(); i++) {
            char c = corridor.charAt(i);

            if (c == 'S') {
                seats++;
            } else { // c == 'P'
                if (seats == 2) {
                    plants++;
                }
            }

            // When we found the third seat, we complete a segment
            if (seats == 3) {
                ans = (ans * (plants + 1)) % MOD; // multiply ways
                seats = 1;   // start new segment with current seat
                plants = 0;  // reset plants count between segments
            }
        }

        // If last segment doesn't have exactly two seats, return 0
        if (seats != 2) {
            return 0;
        }

        return (int) ans;
    }
}
