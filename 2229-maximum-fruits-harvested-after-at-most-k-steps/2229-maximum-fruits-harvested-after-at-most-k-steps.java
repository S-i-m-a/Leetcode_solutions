class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int windowStart = 0;
        long windowSum = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            int rightPos = fruits[windowEnd][0];
            int rightAmt = fruits[windowEnd][1];
            windowSum += rightAmt;

            // Shrink window from left if cost exceeds k
            while (windowStart <= windowEnd) {
                int leftPos = fruits[windowStart][0];
                long cost = (long)(rightPos - leftPos)
                    + Math.min(Math.abs(startPos - leftPos), Math.abs(startPos - rightPos));
                if (cost <= k) {
                    break;
                }
                windowSum -= fruits[windowStart][1];
                windowStart++;
            }

            maxFruits = (int)Math.max(maxFruits, windowSum);
        }

        return maxFruits;
    }
}
