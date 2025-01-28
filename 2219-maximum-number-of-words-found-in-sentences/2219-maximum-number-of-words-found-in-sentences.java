public class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;

        for (String sentence : sentences) {
            // Count the number of words in the current sentence
            int wordCount = sentence.split(" ").length;

            // Update maxWords if the current sentence has more words
            maxWords = Math.max(maxWords, wordCount);
        }

        return maxWords;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        String[] sentences = {"Alice and Bob love coding", "I love LeetCode", "Coding is fun"};
        System.out.println("Maximum Words in a Sentence: " + solution.mostWordsFound(sentences));
    }
}
