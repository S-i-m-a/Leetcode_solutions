class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefixXor = new int[n + 1];
        
        // Step 1: Compute the prefix XOR array
        for (int i = 0; i < n; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }

        // Step 2: Count the number of triplets where XOR of subarrays are equal
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prefixXor[i] == prefixXor[j + 1]) {
                    count += (j - i);
                }
            }
        }

        return count;
    }
}
