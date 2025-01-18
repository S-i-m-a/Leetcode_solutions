public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;  // Base case: empty string has 1 way (doing nothing)

        // If the first character is not '0', there's 1 way to decode it
        dp[1] = (s.charAt(0) != '0') ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            // Check for a valid single digit (between '1' and '9')
            if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') {
                dp[i] += dp[i - 1];
            }
            // Check for a valid two-digit number (between '10' and '26')
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("226"));  // Output: 3
        System.out.println(solution.numDecodings("12"));   // Output: 2
    }
}
