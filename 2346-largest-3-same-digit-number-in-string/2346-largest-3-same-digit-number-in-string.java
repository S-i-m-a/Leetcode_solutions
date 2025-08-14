class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";  // Keeps track of the best good integer found
        int n = num.length();

        for (int i = 0; i + 2 < n; i++) {
            char c0 = num.charAt(i);
            char c1 = num.charAt(i + 1);
            char c2 = num.charAt(i + 2);

            // Check if three consecutive digits are identical
            if (c0 == c1 && c1 == c2) {
                String trio = num.substring(i, i + 3);
                // Compare lexicographically to find the maximum string
                if (trio.compareTo(ans) > 0) {
                    ans = trio;
                }
            }
        }

        return ans;
    }
}
