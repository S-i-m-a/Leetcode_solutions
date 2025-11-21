class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last  = new int[26];
        Arrays.fill(first, n);
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c]  = i;
        }
        int result = 0;
        for (int c = 0; c < 26; c++) {
            if (first[c] < last[c] - 1) {
                // there is at least one character between the first and last occurrence
                boolean[] seen = new boolean[26];
                for (int j = first[c] + 1; j < last[c]; j++) {
                    seen[s.charAt(j) - 'a'] = true;
                }
                for (int mid = 0; mid < 26; mid++) {
                    if (seen[mid]) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
