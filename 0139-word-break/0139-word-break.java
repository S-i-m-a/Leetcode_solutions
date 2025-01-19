import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Create a set for faster lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // Initialize a dp array where dp[i] indicates whether s[0..i-1] can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty string can be segmented
        
        // Iterate through the string s
        for (int i = 1; i <= s.length(); i++) {
            // Check all possible end positions of substrings ending at i-1
            for (int j = 0; j < i; j++) {
                // If s[j..i-1] is a valid word and s[0..j-1] can be segmented, set dp[i] to true
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further
                }
            }
        }
        
        // The answer is stored in dp[s.length()]
        return dp[s.length()];
    }
}
