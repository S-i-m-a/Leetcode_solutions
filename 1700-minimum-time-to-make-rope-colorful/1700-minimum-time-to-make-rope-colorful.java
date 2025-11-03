class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int total = 0;
        int maxTimeInGroup = neededTime[0];
        
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // same color as previous => need to remove one of them
                total += Math.min(maxTimeInGroup, neededTime[i]);
                // keep the one with larger removal time in this group
                maxTimeInGroup = Math.max(maxTimeInGroup, neededTime[i]);
            } else {
                // different color => new group starts
                maxTimeInGroup = neededTime[i];
            }
        }
        
        return total;
    }
}
