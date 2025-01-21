class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            // Update `twos` for bits already in `ones` that appear again
            twos |= ones & num;

            // XOR `num` with `ones` to track bits appearing odd times
            ones ^= num;

            // Remove bits appearing three times from `ones` and `twos`
            int threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }

        return ones; // `ones` contains the single number
    }
}
