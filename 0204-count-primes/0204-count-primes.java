class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0; // No primes less than 2
        
        // Boolean array to track prime status
        boolean[] isPrime = new boolean[n];
        // Mark all numbers as prime initially
        Arrays.fill(isPrime, true);
        
        // 0 and 1 are not prime
        isPrime[0] = isPrime[1] = false;

        // Apply the Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark multiples of i as non-prime
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count the number of primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
