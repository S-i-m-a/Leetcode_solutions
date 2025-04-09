import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        // Add original numbers to the set
        for (int num : nums) {
            uniqueNumbers.add(num);
            uniqueNumbers.add(reverse(num));
        }

        return uniqueNumbers.size();
    }

    private int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}
