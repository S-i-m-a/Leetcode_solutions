import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;
        
        if (s.length() < totalLength) return result;

        // Create a frequency map for words
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Iterate over the string
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            int count = 0;
            HashMap<String, Integer> windowMap = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                
                if (wordMap.containsKey(word)) {
                    // Add word to window map and increase count
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If word frequency exceeds target frequency, shrink window
                    while (windowMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        left += wordLength;
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                    }

                    // If count equals word count, we found a valid substring
                    if (count == wordCount) {
                        result.add(left);
                        // Move the left pointer to look for new substring
                        String leftWord = s.substring(left, left + wordLength);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                } else {
                    // Reset the window if current word is not valid
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
