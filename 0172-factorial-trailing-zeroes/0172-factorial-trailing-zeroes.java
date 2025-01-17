public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5; // Count multiples of 5, 25, 125, etc.
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 100;
        System.out.println("Trailing zeroes in " + n + "! : " + solution.trailingZeroes(n));
    }
}
