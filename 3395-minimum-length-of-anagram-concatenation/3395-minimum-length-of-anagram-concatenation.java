import java.util.*;

public class Solution {
    public int minAnagramLength(String s) {
        int n = s.length();
        for (int len = 1; len <= n; len++) {
            if (n % len != 0) continue;

            if (isValid(s, len)) {
                return len;
            }
        }
        return n;
    }

    private boolean isValid(String s, int len) {
        int[] baseFreq = getFreq(s.substring(0, len));

        for (int i = len; i < s.length(); i += len) {
            String part = s.substring(i, i + len);
            int[] partFreq = getFreq(part);
            if (!Arrays.equals(baseFreq, partFreq)) {
                return false;
            }
        }

        return true;
    }

    private int[] getFreq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
