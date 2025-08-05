class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int count = 0;
        
        for (int[] rect : rectangles) {
            // The largest square side you can cut from a rectangle
            int side = Math.min(rect[0], rect[1]);
            
            if (side > maxLen) {
                maxLen = side;
                count = 1; // reset count for new maximum
            } else if (side == maxLen) {
                count++;
            }
            // If side < maxLen, do nothing
        }
        
        return count;
    }
}
