import java.util.*;

class Solution {
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> gcdCount = new HashMap<>();
        long result = 0;

        for (int num : nums) {
            int gcd1 = gcd(num, k);
            for (int gcd2 : gcdCount.keySet()) {
                if (((long) gcd1 * gcd2) % k == 0) {
                    result += gcdCount.get(gcd2);
                }
            }
            gcdCount.put(gcd1, gcdCount.getOrDefault(gcd1, 0) + 1);
        }

        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
