import java.util.*;

public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // Build a trie from the dictionary
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.isEndOfWord = true;
            node.word = word;
        }

        // Split the sentence into words
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        // Replace each word with its root if found in the trie
        for (String word : words) {
            String replacement = getRoot(word, root);
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(replacement);
        }

        return result.toString();
    }

    // Function to find the root of the word
    private String getRoot(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                return word; // If no root found, return the word as it is
            }
            node = node.children.get(c);
            if (node.isEndOfWord) {
                return node.word; // Return the root word
            }
        }
        return word; // Return the word if no root is found
    }

    // Trie node class
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
        String word = "";
    }
}
