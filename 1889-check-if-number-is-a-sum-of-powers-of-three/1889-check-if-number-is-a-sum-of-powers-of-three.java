class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            int remainder = n % 3;
            if (remainder > 1) {
                return false; // Cannot represent as a sum of distinct powers of three
            }
            n /= 3; // Move to the next digit in base-3 representation
        }
        return true;
    }
}
