public class Solution {
    public String strWithout3a3b(int A, int B) {
        return strWithout3a3b(A, B, 'a', 'b');
    }

    // Helper method to handle the recursive logic
    private String strWithout3a3b(int A, int B, char a, char b) {
        if (A < B)
            return strWithout3a3b(B, A, b, a);  // Swap to ensure A is always >= B
        if (B == 0)
            return new String(new char[Math.min(A, 2)]).replace('\0', a);  // Use min(A, 2) of 'a'

        int useA = Math.min(A, 2);  // Use at most 2 'a's
        int useB = (A - useA >= B) ? 1 : 0;  // Use 'b' if possible
        return new String(new char[useA]).replace('\0', a) + 
               new String(new char[useB]).replace('\0', b) + 
               strWithout3a3b(A - useA, B - useB, a, b);  // Recursively call for remaining characters
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strWithout3a3b(4, 1));  // Example call
        System.out.println(solution.strWithout3a3b(3, 5));  // Example call
    }
}
