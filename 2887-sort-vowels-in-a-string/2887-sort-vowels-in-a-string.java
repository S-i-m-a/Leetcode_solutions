import java.util.*;

class Solution {
    public String sortVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        
        // Define vowels (lowercase + uppercase)
        Set<Character> vowels = new HashSet<>(
            Arrays.asList('a','e','i','o','u','A','E','I','O','U')
        );
        
        // Collect the vowels in original string
        List<Character> vs = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                vs.add(c);
            }
        }
        
        // Sort the collected vowels (natural char order)
        Collections.sort(vs);
        
        // Rebuild result: iterate over s, when vowel, replace with next from sorted list
        StringBuilder sb = new StringBuilder();
        int vIndex = 0;
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                sb.append(vs.get(vIndex++));
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
