class Solution {
    public int minimumDeletions(String s) {
        int countB = 0; // count of 'b's seen
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                countB++;
            } else { // c == 'a'
                // if there are some 'b's before, we must delete this 'a' or delete all b's seen
                if (countB > 0) {
                    deletions++;
                    // choose min deletions: either remove this 'a' (deletions++)
                    // or remove all prior 'b's => deletions = countB
                    deletions = Math.min(deletions, countB);
                }
            }
        }
        return deletions;
    }
}
