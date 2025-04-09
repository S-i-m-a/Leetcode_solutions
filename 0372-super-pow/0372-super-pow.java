public class Solution {
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return helper(a % MOD, b, b.length - 1);
    }

    private int helper(int a, int[] b, int index) {
        if (index < 0) return 1;

        int part1 = modPow(a, b[index]);
        int part2 = modPow(helper(a, b, index - 1), 10);
        return (part1 * part2) % MOD;
    }

    private int modPow(int x, int n) {
        int result = 1;
        x %= MOD;
        while (n > 0) {
            if (n % 2 == 1) {
                result = (result * x) % MOD;
            }
            x = (x * x) % MOD;
            n /= 2;
        }
        return result;
    }
}
