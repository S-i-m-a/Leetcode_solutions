class Solution {
    /**
     * Checks if all '1's in the binary string form a single contiguous segment.
     * 
     * The logic: If there are multiple segments of '1's, there must be at least
     * one occurrence of "01" pattern (transitioning from '0' back to '1').
     * A single segment means we never go from '0' to '1' after the initial segment.
     * 
     * @param s - A binary string containing only '0's and '1's
     * @return true if all '1's form a single contiguous segment, false otherwise
     */
    public boolean checkOnesSegment(String s) {
        // Check if the string does NOT contain the pattern "01"
        // If "01" is absent, all '1's must be in a single contiguous segment
        return !s.contains("01");
    }
}