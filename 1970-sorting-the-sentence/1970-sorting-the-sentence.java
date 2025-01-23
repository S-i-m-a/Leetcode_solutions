public class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] result = new String[words.length];
        
        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '1';
            result[index] = word.substring(0, word.length() - 1);
        }
        
        return String.join(" ", result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "is2 sentence4 This1 a3";
        System.out.println(solution.sortSentence(s));  // Output: "This is a sentence"
    }
}
