import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // Set for exact (case-sensitive) matches
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        
        // Map for lowercase → original first occurrence
        Map<String, String> caseInsensitive = new HashMap<>();
        
        // Map for vowel‐error key → original first occurrence
        Map<String, String> vowelError = new HashMap<>();
        
        // Preprocess wordlist
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            // Case‐insensitive: only store first occurrence
            caseInsensitive.putIfAbsent(lower, word);
            
            // Vowel error: map the “devoweled” version to word
            String devowel = devowel(lower);
            vowelError.putIfAbsent(devowel, word);
        }
        
        String[] ans = new String[queries.length];
        
        // Process each query
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            // 1. Exact match (case-sensitive)
            if (exact.contains(query)) {
                ans[i] = query;
                continue;
            }
            
            // Lowercase version of query
            String qLower = query.toLowerCase();
            
            // 2. Case-insensitive match
            if (caseInsensitive.containsKey(qLower)) {
                ans[i] = caseInsensitive.get(qLower);
                continue;
            }
            
            // 3. Vowel error match: devowel the lowercase query
            String qDevowel = devowel(qLower);
            if (vowelError.containsKey(qDevowel)) {
                ans[i] = vowelError.get(qDevowel);
            } else {
                // 4. No match
                ans[i] = "";
            }
        }
        
        return ans;
    }
    
    // Replace all vowels in the string with a placeholder (e.g. '*')
    private String devowel(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
