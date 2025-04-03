class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                if (isVowelSubstring(word.substring(i, j + 1))) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isVowelSubstring(String s) {
        if (!s.matches("[aeiou]+")) return false;
        boolean[] seen = new boolean[5];
        for (char c : s.toCharArray()) {
            if (c == 'a') seen[0] = true;
            if (c == 'e') seen[1] = true;
            if (c == 'i') seen[2] = true;
            if (c == 'o') seen[3] = true;
            if (c == 'u') seen[4] = true;
        }
        for (boolean b : seen) if (!b) return false;
        return true;
    }
}
