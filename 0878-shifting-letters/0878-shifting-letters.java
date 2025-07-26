class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        long totalShift = 0;
        char[] result = new char[n];

        // Compute the total shifts in reverse
        for (int i = n - 1; i >= 0; i--) {
            totalShift = (totalShift + shifts[i]) % 26;
            result[i] = (char)((s.charAt(i) - 'a' + totalShift) % 26 + 'a');
        }

        return new String(result);
    }
}
