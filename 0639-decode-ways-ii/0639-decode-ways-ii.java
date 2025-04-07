public class Solution {
    static final int MOD = 1000000007;

    public int numDecodings(String s) {
        long prev = 1;  // dp[i - 2]
        long curr = ways(s.charAt(0));  // dp[i - 1]

        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);

            long temp = (curr * ways(currChar) % MOD + prev * ways2(prevChar, currChar) % MOD) % MOD;

            prev = curr;
            curr = temp;
        }

        return (int) curr;
    }

    // Single character decoding
    private int ways(char c) {
        if (c == '*') return 9;
        if (c == '0') return 0;
        return 1;
    }

    // Two character decoding
    private int ways2(char c1, char c2) {
        if (c1 == '*' && c2 == '*') {
            // "**" can represent 11-19 and 21-26 -> total 15
            return 15;
        } else if (c1 == '*') {
            if (c2 >= '0' && c2 <= '6') return 2; // * can be 1 or 2
            else return 1; // * can only be 1
        } else if (c2 == '*') {
            if (c1 == '1') return 9;
            else if (c1 == '2') return 6;
            else return 0;
        } else {
            int num = (c1 - '0') * 10 + (c2 - '0');
            return (num >= 10 && num <= 26) ? 1 : 0;
        }
    }
}
