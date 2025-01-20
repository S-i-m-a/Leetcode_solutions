class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        
        int n = ratings.length;
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        
        Arrays.fill(leftToRight, 1);
        Arrays.fill(rightToLeft, 1);
        
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            }
        }
        
        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += Math.max(leftToRight[i], rightToLeft[i]);
        }
        
        return totalCandies;
    }
}
