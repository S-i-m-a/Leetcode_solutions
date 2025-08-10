class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers aren't palindromes; those ending in 0 (but not 0 itself) can't be either
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Reverse half the number until it's >= the remaining half
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even length: x == reversedHalf
        // For odd length: x == reversedHalf/10
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
