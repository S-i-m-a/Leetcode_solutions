class Solution {
    public int numSub(String s) {
        long MOD = 1_000_000_007;
        long count = 0, result = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                if (count > 0) {
                    result = (result + count * (count + 1) / 2) % MOD;
                    count = 0;
                }
            }
        }
        if (count > 0) {
            result = (result + count * (count + 1) / 2) % MOD;
        }
        return (int) result;
    }
}
