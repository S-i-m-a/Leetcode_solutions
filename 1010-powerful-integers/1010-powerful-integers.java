import java.util.*;

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();

        for (int i = 1; i < bound; i *= (x == 1 ? bound + 1 : x)) {
            for (int j = 1; i + j <= bound; j *= (y == 1 ? bound + 1 : y)) {
                result.add(i + j);
            }
        }

        return new ArrayList<>(result);
    }
}
