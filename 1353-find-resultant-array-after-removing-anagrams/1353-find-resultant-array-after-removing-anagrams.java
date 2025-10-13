import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) return result;
        
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String prev = result.get(result.size() - 1);
            String curr = words[i];
            if (!areAnagrams(prev, curr)) {
                result.add(curr);
            }
        }
        return result;
    }

    private boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}
