public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int start = 0, end = 0;
        int totalCost = 0;
        int maxLength = 0;

        // Sliding window approach
        while (end < n) {
            // Calculate the cost to convert s[end] to t[end]
            totalCost += Math.abs(s.charAt(end) - t.charAt(end));
            
            // If the cost exceeds maxCost, move the start pointer to reduce the cost
            while (totalCost > maxCost) {
                totalCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, end - start + 1);
            
            // Move the end pointer to expand the window
            end++;
        }
        
        return maxLength;
    }
}
