class Solution {
    public int getMaxLen(int[] nums) {
        int posLen = 0, negLen = 0, maxLen = 0;
        for (int num : nums) {
            if (num > 0) {
                posLen++;
                negLen = (negLen > 0) ? negLen + 1 : 0;
            } else if (num < 0) {
                int prevPos = posLen;
                posLen = (negLen > 0) ? negLen + 1 : 0;
                negLen = prevPos + 1;
            } else { // num == 0
                posLen = 0;
                negLen = 0;
            }
            maxLen = Math.max(maxLen, posLen);
        }
        return maxLen;
    }
}
