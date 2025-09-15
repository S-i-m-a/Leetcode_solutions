class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Build a set of broken letters for fast lookup
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        int count = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            if (canType(word, broken)) {
                count++;
            }
        }

        return count;
    }

    private boolean canType(String word, boolean[] broken) {
        for (char c : word.toCharArray()) {
            if (broken[c - 'a']) {
                return false;
            }
        }
        return true;
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        String text1 = "hello world";
        String broken1 = "ad";
        System.out.println(sol.canBeTypedWords(text1, broken1));  // expected 1

        String text2 = "leet code";
        String broken2 = "lt";
        System.out.println(sol.canBeTypedWords(text2, broken2));  // expected 0

        String text3 = "leet code";
        String broken3 = "e";
        System.out.println(sol.canBeTypedWords(text3, broken3));  // expected 1
    }
}
