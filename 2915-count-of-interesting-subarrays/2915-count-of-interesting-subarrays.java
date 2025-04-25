import java.util.*;

public class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> freqMap = new HashMap<>();
        freqMap.put(0, 1L); // initial prefix mod count

        long result = 0;
        int count = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                count++;
            }

            int currMod = count % modulo;
            int targetMod = (currMod - k + modulo) % modulo;

            result += freqMap.getOrDefault(targetMod, 0L);

            freqMap.put(currMod, freqMap.getOrDefault(currMod, 0L) + 1);
        }

        return result;
    }
}
