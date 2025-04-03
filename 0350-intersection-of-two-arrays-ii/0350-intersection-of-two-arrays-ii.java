import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for (int num : nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (freqMap.getOrDefault(num, 0) > 0) {
                resultList.add(num);
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
