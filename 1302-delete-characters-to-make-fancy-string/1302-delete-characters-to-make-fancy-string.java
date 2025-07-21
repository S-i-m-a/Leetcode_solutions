class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = ans.length();
            // If last two chars are 'c', skip this to avoid triple
            if (len > 1 && ans.charAt(len - 1) == c && ans.charAt(len - 2) == c) {
                continue;
            }
            ans.append(c);
        }
        return ans.toString();
    }
}
