class Solution {
    public int alternateDigitSum(int n) {
        String s = n + "";
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += (i % 2 == 0 ? 1 : -1) * (s.charAt(i) - '0');
        return sum;
    }
}
