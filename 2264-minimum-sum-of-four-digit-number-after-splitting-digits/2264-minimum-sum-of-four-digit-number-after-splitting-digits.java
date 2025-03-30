import java.util.*;
class Solution {
    public int minimumSum(int num) {
        int[] d = new int[4];
        for (int i = 0; i < 4; i++, num /= 10) d[i] = num % 10;
        Arrays.sort(d);
        return d[0] * 10 + d[2] + d[1] * 10 + d[3];
    }
}
