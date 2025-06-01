import java.util.*;

public class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX = 100_005; // Increased limit
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];

    static {
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    public int countAnagrams(String s) {
        String[] words = s.split(" ");
        long result = 1;

        for (String word : words) {
            int[] count = new int[26];
            int len = word.length();

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            long ways = fact[len];
            for (int c : count) {
                if (c > 1) {
                    ways = (ways * invFact[c]) % MOD;
                }
            }

            result = (result * ways) % MOD;
        }

        return (int) result;
    }

    static long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) != 0) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    static long modInverse(long n) {
        return modPow(n, MOD - 2);
    }
}
