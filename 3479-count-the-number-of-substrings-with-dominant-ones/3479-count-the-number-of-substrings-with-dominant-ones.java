class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        // iterate over possible number of zeros in the substring
        for (int zero = 0; zero + zero * zero <= n; ++zero) {
            int lastInvalid = -1;
            int count0 = 0, count1 = 0;
            int l = 0;
            for (int r = 0; r < n; ++r) {
                if (s.charAt(r) == '0') {
                    ++count0;
                } else {
                    ++count1;
                }
                // shrink from left to make substring minimal while still valid
                while (l < r) {
                    if (s.charAt(l) == '0' && count0 > zero) {
                        --count0;
                        lastInvalid = l;
                        ++l;
                    } else if (s.charAt(l) == '1' && count1 - 1 >= zero * zero) {
                        --count1;
                        ++l;
                    } else {
                        break;
                    }
                }
                if (count0 == zero && count1 >= zero * zero) {
                    ans += l - lastInvalid;
                }
            }
        }
        return ans;
    }
}
