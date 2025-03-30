import java.util.*;
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums)
            for (char c : (n + "").toCharArray())
                list.add(c - '0');
        return list.stream().mapToInt(i -> i).toArray();
    }
}
