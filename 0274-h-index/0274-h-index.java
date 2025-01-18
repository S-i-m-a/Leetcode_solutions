public class Solution {
    public int hIndex(int[] citations) {
        // Step 1: Sort the array in descending order
        Arrays.sort(citations);
        
        int n = citations.length;
        int hIndex = 0;
        
        // Step 2: Check for the largest h such that there are h papers with at least h citations
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                hIndex = n - i;
                break;
            }
        }
        
        return hIndex;
    }
}
