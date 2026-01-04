class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += sumIfFourDivisors(num);
        }
        return total;
    }

    // Returns sum of divisors only if `n` has exactly 4 divisors; otherwise 0
    private int sumIfFourDivisors(int n) {
        int count = 2;         // 1 and n
        int sum = 1 + n;       // include 1 and n

        // Check from 2 up to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    // perfect square; add only once
                    count++;
                    sum += i;
                } else {
                    count += 2; 
                    sum += i + (n / i);
                }
            }
            // If count exceeds 4, we can stop early
            if (count > 4) {
                return 0;
            }
        }

        // Return sum only if exactly 4 divisors
        return (count == 4) ? sum : 0;
    }
}
