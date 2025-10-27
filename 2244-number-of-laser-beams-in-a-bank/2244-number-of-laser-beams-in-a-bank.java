class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int prevOnes = 0;
        for (String row : bank) {
            int curOnes = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') curOnes++;
            }
            if (curOnes > 0) {
                ans += prevOnes * curOnes;
                prevOnes = curOnes;
            }
        }
        return ans;
    }
}
