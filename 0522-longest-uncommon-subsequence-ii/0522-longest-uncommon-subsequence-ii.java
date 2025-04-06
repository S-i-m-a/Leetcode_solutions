import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findLUSlength(String[] strs) {
        // Sort strings by length in descending order
        Arrays.sort(strs, (a, b) -> b.length() - a.length());

        // Identify duplicate strings
        Set<String> duplicates = findDuplicates(strs);

        for (int i = 0; i < strs.length; i++) {
            // Skip duplicate strings
            if (duplicates.contains(strs[i])) continue;

            boolean isUncommon = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }
            }

            if (isUncommon) return strs[i].length();
        }

        return -1;
    }

    private Set<String> findDuplicates(String[] strs) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String s : strs) {
            if (!seen.add(s)) {
                duplicates.add(s);
            }
        }
        return duplicates;
    }

    private boolean isSubsequence(String a, String b) {
        int i = 0;
        for (char c : b.toCharArray()) {
            if (i < a.length() && a.charAt(i) == c) {
                i++;
            }
        }
        return i == a.length();
    }
}
