import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int largestInteger(int num) {
        // Separate even and odd digits
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        char[] digits = String.valueOf(num).toCharArray();

        for (char digit : digits) {
            int d = digit - '0';
            if (d % 2 == 0) {
                even.add(d);
            } else {
                odd.add(d);
            }
        }

        // Sort both lists in descending order
        Collections.sort(even, Collections.reverseOrder());
        Collections.sort(odd, Collections.reverseOrder());

        // Reconstruct the number
        StringBuilder result = new StringBuilder();
        int evenIndex = 0, oddIndex = 0;

        for (char digit : digits) {
            int d = digit - '0';
            if (d % 2 == 0) {
                result.append(even.get(evenIndex++));
            } else {
                result.append(odd.get(oddIndex++));
            }
        }

        return Integer.parseInt(result.toString());
    }
}
