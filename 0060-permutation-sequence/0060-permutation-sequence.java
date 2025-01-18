import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        // Step 1: Create a list of numbers to get numbers from
        List<Integer> numbers = new ArrayList<>();
        int fact = 1; // factorial of (n-1)
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact *= i; // Compute n!
        }
        
        // Step 2: Convert k to zero-based index
        k--;

        // Step 3: Build the k-th permutation
        StringBuilder result = new StringBuilder();
        for (int i = n; i > 0; i--) {
            fact /= i; // Update factorial to (i-1)!
            int index = k / fact; // Determine which number to pick
            result.append(numbers.get(index)); // Append the selected number
            numbers.remove(index); // Remove the used number
            k %= fact; // Update k
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 3)); // Output: "213"
        System.out.println(solution.getPermutation(4, 9)); // Output: "2314"
    }
}
