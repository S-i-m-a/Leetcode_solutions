class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int[] lps = computeLPSArray(needle);
        int i = 0, j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j; // Match found
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1]; // Move `j` using LPS array
                } else {
                    i++;
                }
            }
        }

        return -1; // No match found
    }

    private int[] computeLPSArray(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int j = 0; // Length of previous longest prefix suffix

        for (int i = 1; i < n; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
            }
        }

        return lps;
    }
}
