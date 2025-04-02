class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += encrypt(num);
        }
        return sum;
    }

    private int encrypt(int num) {
        String numStr = String.valueOf(num);
        char maxDigit = '0';

        // Find the maximum digit
        for (char c : numStr.toCharArray()) {
            if (c > maxDigit) {
                maxDigit = c;
            }
        }

        // Replace all digits with the max digit, keeping the length same
        StringBuilder encryptedStr = new StringBuilder();
        for (int i = 0; i < numStr.length(); i++) {
            encryptedStr.append(maxDigit);
        }

        return Integer.parseInt(encryptedStr.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3};
        System.out.println(solution.sumOfEncryptedInt(nums1)); // Expected: 6 (1 + 2 + 3)

        int[] nums2 = {10, 21, 31};
        System.out.println(solution.sumOfEncryptedInt(nums2)); // Expected: 66 (11 + 22 + 33)

        int[] nums3 = {23, 18, 91};
        System.out.println(solution.sumOfEncryptedInt(nums3)); // Expected: 99 + 88 + 99 = 286

        int[] nums4 = {109}; 
        System.out.println(solution.sumOfEncryptedInt(nums4)); // Expected: 999

        int[] nums5 = {502, 876};
        System.out.println(solution.sumOfEncryptedInt(nums5)); // Expected: 555 + 888 = 1443
    }
}
