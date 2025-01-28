public class Solution {
    public int countValidWords(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split("\\s+");
        int validCount = 0;

        for (String word : words) {
            if (isValidWord(word)) {
                validCount++;
            }
        }

        return validCount;
    }

    private boolean isValidWord(String word) {
        if (word.isEmpty()) return false;

        boolean hasHyphen = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isDigit(ch)) {
                return false; // Digits are not allowed
            } else if (ch == '-') {
                // Hyphen must be in the middle and can appear only once
                if (hasHyphen || i == 0 || i == word.length() - 1 || !Character.isLetter(word.charAt(i - 1)) || !Character.isLetter(word.charAt(i + 1))) {
                    return false;
                }
                hasHyphen = true;
            } else if (ch == '!' || ch == '.' || ch == ',') {
                // Punctuation marks must appear only at the end
                if (i != word.length() - 1) {
                    return false;
                }
            } else if (!Character.isLetter(ch)) {
                return false; // Invalid character
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        String sentence = "cat and  dog";
        System.out.println("Number of Valid Words: " + solution.countValidWords(sentence));

        sentence = "a-b-c";
        System.out.println("Number of Valid Words: " + solution.countValidWords(sentence));

        sentence = "hello-world!";
        System.out.println("Number of Valid Words: " + solution.countValidWords(sentence));
    }
}
