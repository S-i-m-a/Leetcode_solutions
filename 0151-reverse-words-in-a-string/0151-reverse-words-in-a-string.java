public class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim the string to remove leading and trailing spaces
        s = s.trim();
        
        // Step 2: Split the string into words using a single space as delimiter
        String[] words = s.split("\\s+");
        
        // Step 3: Reverse the words
        StringBuilder reversedString = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);
            if (i > 0) {
                reversedString.append(" "); // Add a space between words
            }
        }
        
        // Step 4: Return the reversed string
        return reversedString.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.reverseWords("  the sky is blue  ");
        System.out.println(result);  // Output: "blue is sky the"
    }
}
