class Solution {
    public int numOfSubarrays(int[] arr) {
        long oddCount = 0, evenCount = 1, currentSum = 0, result = 0;
        
        for (int num : arr) {
            currentSum += num;
            
            if (currentSum % 2 == 1) {
                result += evenCount;
                oddCount++;
            } else {
                result += oddCount;
                evenCount++;
            }
        }
        
        return (int)(result % 1000000007); // Handle large results
    }
}
